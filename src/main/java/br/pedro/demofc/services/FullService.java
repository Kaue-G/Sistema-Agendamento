package br.pedro.demofc.services;

import br.pedro.demofc.dtos.BookingDTO;
import br.pedro.demofc.dtos.ChairDTO;
import br.pedro.demofc.dtos.DisponibilityDTO;
import br.pedro.demofc.dtos.Type;
import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.repositories.BookingRepository;
import br.pedro.demofc.repositories.ChairRepository;
import br.pedro.demofc.repositories.DisponibilityRepository;
import br.pedro.demofc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class FullService {

    private final BookingRepository bookingRepository;
    private final DisponibilityRepository disponibilityRepository;
    private final ChairRepository chairRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    FullService(BookingRepository bookingRepository, DisponibilityRepository disponibilityRepository,
                ChairRepository chairRepository, EmployeeRepository employeeRepository){
        this.bookingRepository = bookingRepository;
        this.disponibilityRepository = disponibilityRepository;
        this.chairRepository = chairRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public Page<ChairDTO> findChairsPaged(Pageable pageable, Integer id){
        System.out.println(id);
        Page<Chair> chairs = chairRepository.findByOffice(pageable,id);
        return chairs.map(ChairDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<DisponibilityDTO> findDisponibilities(Pageable pageable, Integer id, LocalDate date, Boolean bool){
        Page<Disponibility> disponibilities = disponibilityRepository.findAllByOffice(pageable,date,id,bool);
        disponibilities.forEach(Disponibility::tryAvailable);
        return disponibilities.map(DisponibilityDTO::new);
    }

    @Transactional
    public BookingDTO insertSingleBooking(BookingDTO dto, Integer id){
        Booking booking = new Booking();

        if(dto.getType() == Type.DAY){
            booking.setBegin(8);
            booking.setEnd(18);
        } else {
            booking.setBegin(dto.getBegin());
            booking.setEnd(dto.getEnd());
        }


        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(dto.getMoment(),booking.getBegin(),booking.getEnd(),id);
        if(disponibilities.isEmpty()){
            throw new ServiceViolationException("[404] This data is not in system: " + dto.getMoment());
        }


        dtoToEntity(dto,booking);
        Booking persisted = bookingRepository.save(booking);
        chairRepository.getById(dto.getChair()).setAvailable(false);

        disponibilities.forEach(disp -> {
            disp.getBookings().add(persisted);
            disp.tryAvailable();
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
        booking.getChair().setAvailable(true);
        List<Disponibility> disp = disponibilityRepository.findByBookingId(id);
        disp.forEach(x -> x.getBookings().remove(booking));
        bookingRepository.delete(booking);
    }
}
