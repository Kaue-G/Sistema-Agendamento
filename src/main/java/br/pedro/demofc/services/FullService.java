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
import java.util.concurrent.atomic.AtomicLong;
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

    public Constraints getConstraints() {
        return constraints;
    }

    @Transactional
    public List<OfficeDTO> findOfficeStateByDate(LocalDate date){
        if(date == null){
            throw new ServiceViolationException("[404] Date can not be null");
        }
        List<Office> offices = oRepository.findAll();
        return offices.stream().map(o -> {
            List<Chair> chairs = chairRepository.findByTypeAndOffice(Type.DAY,o);

            List<Chair> rooms = chairRepository.findByTypeAndOffice(Type.REUNION,o);

            List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(date,constraints.getBEGIN(),constraints.getEND(),o.getId());
            AtomicLong chairsOccupied = new AtomicLong(0L);
            AtomicLong roomsOccupied = new AtomicLong(0L);

            chairs.forEach(chair -> {
                if(disponibilities.stream().anyMatch(disp -> disp.getChairs().contains(chair))){
                    chairsOccupied.getAndIncrement();
                }
            });

            rooms.forEach(room -> {
                if(disponibilities.stream().anyMatch(disp -> disp.getChairs().contains(room))){
                    roomsOccupied.getAndIncrement();
                }
            });

             return new OfficeDTO(o.getId(), o.getName(),roomsOccupied.get(), chairsOccupied.get(),chairs.size(),rooms.size());
        }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<ChairDTO> findChairsPaged(Pageable pageable, Integer id, LocalDate when, Integer begin, Integer end, Type type){
        if(when == null){
            throw new ServiceViolationException("[404] Date can not be null");
        }

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(when,begin,end,id);

        Page<Chair> allChairs = chairRepository.findByOffice(pageable, id, type);

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

    @Transactional(readOnly = true)
    public List<DayDTO> findByDays(Integer id){
        return disponibilityRepository.findDaysOfDisponibilities(id);
    }

    @Transactional
    public BookingDTO insertSingleBooking(BookingDTO dto, Integer id){
        Booking booking = new Booking();

        if(dto.getType() == Type.DAY){
            booking.setBegin(constraints.getBEGIN());
            booking.setEnd(constraints.getEND());
        } else {
            booking.setBegin(dto.getBegin());
            booking.setEnd(dto.getEnd());
        }

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(dto.getMoment(),booking.getBegin(),booking.getEnd(),id);

        if(disponibilities.isEmpty()){
            throw new ServiceViolationException("[404] This data is not in system: " + dto.getMoment());
        }

        dtoToEntity(dto,booking);

        Chair c = chairRepository.findByIdAndOffice(dto.getChair(),id);
        if(c == null){
            throw new ServiceViolationException("[404] This chair does not count on data base or office area");
        }

        Booking persisted = bookingRepository.save(booking);

        disponibilities.forEach(disp -> {
            disp.getBookings().add(persisted);
            disp.getChairs().add(c);
            disp.tryAvailable(constraints.getPERCENTAGE());
        });

        return new BookingDTO(booking,dto.getMoment(),dto.getType(),dto.getChair());
    }

    private void dtoToEntity (BookingDTO dto, Booking booking){
        booking.setMoment(dto.getMoment());
        booking.setEmployee(employeeRepository.getById(dto.getEmployee_id()));
        booking.setChair(chairRepository.getById(dto.getChair()));
    }

    @Transactional
    public void delete(Integer id){
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ServiceViolationException("[404] Entity not Found"));
        List<Disponibility> disp = disponibilityRepository.findByBookingId(id);

        Chair chair = booking.getChair();
        disp.forEach(x -> {
            x.getBookings().remove(booking);
            x.getChairs().remove(chair);
        });

        bookingRepository.delete(booking);
    }
}
