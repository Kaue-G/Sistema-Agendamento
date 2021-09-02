package br.pedro.demofc.services;

import br.pedro.demofc.dtos.BookingDTO;
import br.pedro.demofc.dtos.ChairDTO;
import br.pedro.demofc.dtos.DisponibilityDTO;
import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.repositories.BookingRepository;
import br.pedro.demofc.repositories.ChairRepository;
import br.pedro.demofc.repositories.DisponibilityRepository;
import br.pedro.demofc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<DisponibilityDTO> findDisponibilities(){
        List<Disponibility> disponibilities = disponibilityRepository.findAll();
        disponibilities.forEach(Disponibility::tryAvailable);
        return disponibilities.stream().map(DisponibilityDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ChairDTO> findChairs(){
        List<Chair> chairs = chairRepository.findAll();
        return chairs.stream().map(ChairDTO::new).collect(Collectors.toList());
    }

    private void dtoToEntity (BookingDTO dto, Booking booking){
        booking.setMoment(dto.getMoment()); // Campo inútil
        booking.setBegin(dto.getBegin());
        booking.setEnd(dto.getEnd());
        booking.setEmployee(employeeRepository.getById(dto.getEmployee_id()));
        booking.setChair(chairRepository.getById(dto.getChair()));
    }

    @Transactional
    public BookingDTO insert(BookingDTO dto) {
        Booking booking = new Booking();
        dtoToEntity(dto,booking);

        booking = bookingRepository.save(booking);

        Chair c = chairRepository.getById(dto.getChair());
        c.setAvailable(false);

        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(booking.getMoment(), booking.getBegin(), booking.getEnd());

        Booking finalBooking = booking;

        disponibilities.forEach(disp -> {
            disp.getBookings().add(finalBooking);
        });

        return new BookingDTO(booking);
    }

    @Transactional
    public void delete(Integer id){
        Booking b = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found!"));
        b.getChair().setAvailable(true);
        List<Disponibility> d = disponibilityRepository.findByBookingId(id);
        d.forEach(x -> x.getBookings().remove(b));
        bookingRepository.deleteById(b.getId());
    }
}
