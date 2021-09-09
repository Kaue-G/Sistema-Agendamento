package br.pedro.demofc.services;

import br.pedro.demofc.config.Constraints;
import br.pedro.demofc.dtos.*;
import br.pedro.demofc.entities.*;
import br.pedro.demofc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FullService {
    private final Constraints constraints;

    private final BookingRepository bookingRepository;
    private final DisponibilityRepository disponibilityRepository;
    private final ChairRepository chairRepository;
    private final EmployeeRepository employeeRepository;
    private final OfficeRepository oRepository;

    @Autowired
    FullService(BookingRepository bookingRepository, DisponibilityRepository disponibilityRepository,
                ChairRepository chairRepository, EmployeeRepository employeeRepository, OfficeRepository oRepository,
                Constraints constraints){
        this.bookingRepository = bookingRepository;
        this.disponibilityRepository = disponibilityRepository;
        this.chairRepository = chairRepository;
        this.employeeRepository = employeeRepository;
        this.oRepository = oRepository;

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

    @Transactional
    public OfficeStateDTO findOfficeStateByDate(Integer id, LocalDate date){
        Office office = oRepository.findById(id).orElseThrow(() -> new ServiceViolationException("[404] Office not found"));

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(date,constraints.getBEGIN(),constraints.getEND(),office.getId());
        List<Chair> chairs = office.getChairs();

        int maxValue = disponibilities.stream().mapToInt(disp -> disp.getBookings().size()).max().orElse(0);
        int occupiedRooms = (int) chairs.stream().filter(chair -> disponibilities.stream().anyMatch(disp -> disp.getChairs().contains(chair))).count();
        int restrictedCapacity = (int) Math.ceil(office.getCapacity() * (constraints.getPERCENTAGE()) / 100);

        return new OfficeStateDTO(office.getId(), restrictedCapacity, maxValue, chairs.size(), occupiedRooms);
    }

    @Transactional(readOnly = true)
    public Page<ChairDTO> findChairsPaged(Pageable pageable, Integer id, LocalDate when, Integer begin, Integer end){

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(when,begin,end,id);

        Page<Chair> allChairs = chairRepository.findByOffice(pageable, id);

        return allChairs.map(chair -> {
            boolean isOccupied =  true;
            for(Disponibility disp : disponibilities){
                if (disp.getChairs().contains(chair)) {
                    isOccupied = false;
                    break;
                }
            }
            return new ChairDTO(chair, isOccupied);
        });
    }

    @Transactional(readOnly = true)
    public Page<DisponibilityDTO> findDisponibilities(Pageable pageable, Integer id, LocalDate date, Boolean bool){
        Page<Disponibility> disponibilities = disponibilityRepository.findAllByOffice(pageable,date,id,bool);

        disponibilities.forEach(disp -> disp.tryAvailable(constraints.getPERCENTAGE()));
        return disponibilities.map(DisponibilityDTO::new);
    }

    @Transactional
    public BookingDTO insertSingleBooking(BookingDTO dto, Integer id){
        Booking booking = new Booking();

        booking.setMoment(dto.getMoment());
        booking.setEmployee(employeeRepository.getById(dto.getEmployee_id()));

        if(dto.getType() == Type.DAY){
            booking.setBegin(constraints.getBEGIN());
            booking.setEnd(constraints.getEND());
            booking.setChair(null);
        } else {
            booking.setBegin(dto.getBegin());
            booking.setEnd(dto.getEnd());
            booking.setChair(dto.getChair());
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
            Chair c = chairRepository.findByIdAndOffice(dto.getChair(),id);

            disponibilities.forEach(disp -> {
                disp.getBookings().add(persisted);
                disp.getChairs().add(c);
                disp.tryAvailable(constraints.getPERCENTAGE());
            });
        }
        return new BookingDTO(booking,dto.getMoment(),dto.getType(),booking.getChair());
    }

    @Transactional
    public void delete(Integer id){
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ServiceViolationException("[404] Entity not Found"));
        List<Disponibility> disp = disponibilityRepository.findByBookingId(id);

        if(booking.getChair() == null){
            disp.forEach(x -> {
                x.getBookings().remove(booking);
            });
        } else {
            Optional<Chair> chair = chairRepository.findById(booking.getChair());

            chair.ifPresent(value -> {
                disp.forEach(x -> {
                    x.getBookings().remove(booking);
                    x.getChairs().remove(value);
                });
            });
        }
        bookingRepository.delete(booking);
    }
}