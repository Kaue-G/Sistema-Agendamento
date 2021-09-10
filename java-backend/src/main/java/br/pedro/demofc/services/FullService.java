package br.pedro.demofc.services;

import br.pedro.demofc.config.Constraints;
import br.pedro.demofc.dtos.*;
import br.pedro.demofc.entities.*;
import br.pedro.demofc.entities.pk.DisponibilityRoomPK;
import br.pedro.demofc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FullService {
    private final Constraints constraints;

    private final BookingRepository bookingRepository;
    private final DisponibilityRepository disponibilityRepository;
    private final RoomRepository roomRepository;
    private final EmployeeRepository employeeRepository;
    private final OfficeRepository oRepository;
    private final DisponibilityRoomRepository drRepository;

    @Autowired
    FullService(BookingRepository bookingRepository, DisponibilityRepository disponibilityRepository,
                RoomRepository roomRepository, EmployeeRepository employeeRepository, OfficeRepository oRepository,
                DisponibilityRoomRepository drRepository,
                Constraints constraints){
        this.bookingRepository = bookingRepository;
        this.disponibilityRepository = disponibilityRepository;
        this.roomRepository = roomRepository;
        this.employeeRepository = employeeRepository;
        this.oRepository = oRepository;
        this.drRepository = drRepository;

        this.constraints = constraints;
    }

    @Transactional(readOnly = true)
    public List<OfficeDTO> findOffices(){
        List<Office> offices = oRepository.findAll();

        return offices.stream().map(of -> {
            List<DayDTO> days = disponibilityRepository.findDaysOfDisponibilities(of.getId());
            int rooms = of.getChairs().size();
            int restrictedCapacity = (int) Math.ceil(of.getCapacity() * (constraints.getPERCENTAGE()) / 100);
            return new OfficeDTO(of.getId(), of.getName(), of.getAddress(), rooms, restrictedCapacity, days);
        }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OfficeStateDTO findOfficeStateByDate(Integer id, LocalDate date){
        Office office = oRepository.findById(id).orElseThrow(() -> new ServiceViolationException("[404] Office not found"));

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(date,constraints.getBEGIN(),constraints.getEND(),office.getId());
        List<Room> rooms = office.getChairs();

        int maxValue = disponibilities.stream().mapToInt(Disponibility::getAmount).max().orElse(0);
        int restrictedCapacity = (int) Math.ceil(office.getCapacity() * (constraints.getPERCENTAGE()) / 100);

        return new OfficeStateDTO(office.getId(), restrictedCapacity, maxValue, rooms.size());
    }

    @Transactional(readOnly = true)
    public Page<RoomDTO> findChairsPaged(Pageable pageable, Integer id, LocalDate when, Integer begin, Integer end){

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(when,begin,end,id);

        Page<Room> allChairs = roomRepository.findByOffice(pageable, id);

        // RESTRINGIR ESSA BUSCA POR DATA ESCRITORIO E HORA
        List<DisponibilityRoom> dRooms = drRepository.findAll();

        return allChairs.map(chair -> {
            boolean isOccupied =  true;
            int occupiedAmount = 0;
            for(Disponibility disp : disponibilities){
                DisponibilityRoomPK pk = new DisponibilityRoomPK(disp.getId(),chair.getId());
                List<DisponibilityRoom> containedRooms = dRooms.stream().filter(droom -> droom.getId().equals(pk)).collect(Collectors.toList());

                if(!containedRooms.isEmpty()){
                    if(containedRooms.get(0).getCapacity() >= chair.getCapacity()){
                        isOccupied = false;
                    }
                    occupiedAmount = containedRooms.get(0).getCapacity();
                }
            }
            return new RoomDTO(chair, isOccupied, occupiedAmount);
        });
    }

    @Transactional(readOnly = true)
    public List<DisponibilityDTO> findDisponibilities(Integer id, LocalDate date, Boolean bool){
        List<Disponibility> disponibilities = disponibilityRepository.findAllByOffice(date,id,bool);

        disponibilities.forEach(disp -> disp.tryAvailable(constraints.getPERCENTAGE()));
        return disponibilities.stream().map(DisponibilityDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BookingDTO> findAllBookings(String email) {
        Employee e = employeeRepository.findById(email).orElseThrow(() -> new ServiceViolationException("[404] Entity not Found"));
        List<Booking> bookings = bookingRepository.findBookingByEmployee(e);

        return bookings.stream().map(x -> {
            Disponibility d = x.getDisponibilities().stream().findFirst().orElseThrow(() -> new ServiceViolationException("[404] Booking whiteout disponibility"));
            String officeName = d.getOffice().getName();
            return new BookingDTO(x, officeName);
        }).collect(Collectors.toList());
    }

    @Transactional
    public BookingDTO insertSingleBooking(BookingDTO dto, Integer id){
        Booking booking = new Booking();

        booking.setMoment(dto.getMoment());
        booking.setEmployee(employeeRepository.getById(dto.getEmployee_id()));

        if(dto.getType() == Type.DAY){
            booking.setBegin(constraints.getBEGIN());
            booking.setEnd(constraints.getEND());
            booking.setRoom(null);
            booking.setWeight(1);
        } else {
            booking.setBegin(dto.getBegin());
            booking.setEnd(dto.getEnd());
            booking.setRoom(dto.getChair());
            booking.setWeight(2);
        }

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(dto.getMoment(), booking.getBegin(), booking.getEnd(), id);

        if(disponibilities.isEmpty()){
            throw new ServiceViolationException("[404] This data is not in system: " + dto.getMoment());
        }

        Booking persisted = bookingRepository.save(booking);

        if(dto.getType() == Type.DAY){
            disponibilities.forEach(disp -> {
                disp.getBookings().add(persisted);
                disp.tryAvailable(constraints.getPERCENTAGE());
            });
        } else {
            Room c = roomRepository.findByIdAndOffice(dto.getChair(),id);

            if(dto.getWeight() > c.getCapacity()){
                throw new ServiceViolationException("[422] The weight must me smaller than room capacity");
            }

            List<DisponibilityRoom> allRooms = drRepository.findAll();

            disponibilities.forEach(disp -> {
                DisponibilityRoom newDr = new DisponibilityRoom(disp,c);
                Optional<DisponibilityRoom> dRoom = allRooms.stream().filter(room -> room.equals(newDr)).findAny();

                dRoom.ifPresent(disponibilityRoom -> {
                    disponibilityRoom.addBooking(dto.getWeight());
                    drRepository.save(disponibilityRoom);
                });

                if(dRoom.isEmpty()){
                    newDr.setCapacity(dto.getWeight());
                    drRepository.save(newDr);
                }

                disp.getBookings().add(persisted);
                disp.tryAvailable(constraints.getPERCENTAGE());
            });
        }
        return new BookingDTO(booking,dto.getMoment(),dto.getType(),booking.getRoom());
    }

    @Transactional
    public void delete(Integer id){
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ServiceViolationException("[404] Entity not Found"));
        Set<Disponibility> disp = booking.getDisponibilities();

        if(booking.getRoom() == null){
            disp.forEach(x -> {
                x.getBookings().remove(booking);
            });
        } else {
            Optional<Room> chair = roomRepository.findById(booking.getRoom());
            chair.ifPresent(value -> disp.forEach(x -> {
                DisponibilityRoomPK pk = new DisponibilityRoomPK(x.getId(),value.getId());
                DisponibilityRoom dr = drRepository.getById(pk);
                if(dr.getCapacity() <= 2){
                    drRepository.delete(dr);
                } else {
                    dr.setCapacity(dr.getCapacity() - booking.getWeight());
                }
                x.getBookings().remove(booking);
            }));
        }
        bookingRepository.delete(booking);
    }
}