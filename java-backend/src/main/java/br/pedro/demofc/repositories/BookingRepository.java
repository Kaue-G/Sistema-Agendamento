package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    Booking findByEmployeeAndMoment(Employee e, LocalDate date);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"disponibilities"})
    List<Booking> findBookingByEmployee(Employee e);

    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"disponibilities"})
    Optional<Booking> findById(@NonNull String id);
}
