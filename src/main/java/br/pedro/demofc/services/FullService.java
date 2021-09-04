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
        Page<Chair> chairs = chairRepository.findByOffice(pageable,id);
        return chairs.map(ChairDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<DisponibilityDTO> findDisponibilities(Pageable pageable, Integer id, LocalDate date, Boolean bool){
        Page<Disponibility> disponibilities = disponibilityRepository.findAllByOffice(pageable,id,date,bool);
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
            throw new ServiceViolationException("This data is not in system: " + dto.getMoment());
        }

        dtoToEntity(dto,booking);
        Booking persisted = bookingRepository.save(booking);
        chairRepository.getById(dto.getChair()).setAvailable(false);

        disponibilities.forEach(disp -> disp.getBookings().add(persisted));

        return new BookingDTO(booking,dto.getMoment(),dto.getType(),dto.getChair());
    }

    private void dtoToEntity (BookingDTO dto, Booking booking){
        booking.setMoment(dto.getMoment());
        booking.setEmployee(employeeRepository.getById(dto.getEmployee_id()));
        booking.setChair(chairRepository.getById(dto.getChair()));
    }

//    @Transactional
//    public BookingDTO insert(BookingDTO dto) {
//        Booking booking = new Booking();
//        dtoToEntity(dto,booking);
//
//        booking = bookingRepository.save(booking);
//
//        Chair c = chairRepository.getById(dto.getChair());
//        c.setAvailable(false);
//
//        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(booking.getMoment(), booking.getBegin(), booking.getEnd());
//
//        Booking finalBooking = booking;
//
//        disponibilities.forEach(disp -> {
//            disp.getBookings().add(finalBooking);
//        });
//
//        return new BookingDTO(booking);
//    }

    @Transactional
    public void delete(Integer id){
        Booking b = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found!"));
        b.getChair().setAvailable(true);
        List<Disponibility> d = disponibilityRepository.findByBookingId(id);
        d.forEach(x -> x.getBookings().remove(b));
        bookingRepository.deleteById(b.getId());
    }

    //Post or update
}
