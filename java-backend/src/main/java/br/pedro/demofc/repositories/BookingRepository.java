package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    Booking findByEmployeeAndMoment(Employee e, LocalDate date);

    List<Booking> findBookingByEmployee(Employee e);
}
