package br.pedro.demofc.services;

import br.pedro.demofc.config.Constraints;
import br.pedro.demofc.dtos.*;
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
    private final Constraints constraints;

    private final BookingRepository bookingRepository;
    private final DisponibilityRepository disponibilityRepository;
    private final ChairRepository chairRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    FullService(BookingRepository bookingRepository, DisponibilityRepository disponibilityRepository,
                ChairRepository chairRepository, EmployeeRepository employeeRepository,
                Constraints constraints){
        this.bookingRepository = bookingRepository;
        this.disponibilityRepository = disponibilityRepository;
        this.chairRepository = chairRepository;
        this.employeeRepository = employeeRepository;

        this.constraints = constraints;
    }

    @Transactional(readOnly = true)
    public Page<ChairDTO> findChairsPaged(Pageable pageable, Integer id, LocalDate when, Integer begin, Integer end){
        // Pegando todas as disponibilidades nessa data, começo e fim
        List<Disponibility> disponibilities = disponibilityRepository.findByEndAndBegin(when,begin,end,id);
        //disponibilities.forEach(d -> System.out.println("Office: " + d.getOffice().getId()));
//        disponibilities.forEach(d -> {
//            System.out.println(d.getId().getBeginHour() + ":  ");
//            for(Chair c : d.getChairs()){
//                System.out.println("[CADEIRA]" + c.getId());
//            }
//        });

        // Disponibilidade das 8h
        Disponibility d = disponibilities.get(0);

        // DIsponibilidade das 18h
        Disponibility f = disponibilities.get(disponibilities.size() - 1);


        // Busca de todas as cadeiras
        Page<Chair> allChairs = chairRepository.findByOffice(pageable, id);

        //allChairs.forEach(c -> System.out.println(c.getOffice().getId() + "," + c.getId()));


        return allChairs.map(chair -> {
            // Para cada cadeira testar os horários em q contém ela
            boolean isOccupied =  true;
            for(Disponibility disp : disponibilities){
                if(disp.getChairs().contains(chair)){
                    isOccupied = false;
                }
            }
            return new ChairDTO(chair, isOccupied);
//            boolean occupied;
//            occupied = !d.getChairs().contains(chair) || !f.getChairs().contains(chair);
//            return new ChairDTO(chair, occupied);
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
        System.out.println(booking.getChair().getId());

        Chair chair = booking.getChair();
        disp.forEach(x -> {
            x.getBookings().remove(booking);
            x.getChairs().remove(chair);
            //x.getChairs().forEach(ch -> System.out.println(ch.getId()));
        });

        bookingRepository.delete(booking);
    }
}
