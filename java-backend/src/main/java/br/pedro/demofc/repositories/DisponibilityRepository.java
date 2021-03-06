package br.pedro.demofc.repositories;

import br.pedro.demofc.dtos.DayDTO;
import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.entities.pk.DisponibilityPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DisponibilityRepository extends JpaRepository<Disponibility, DisponibilityPK> {

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"office", "bookings"})
    @Query("SELECT disp FROM Disponibility disp WHERE disp.id.moment = :moment AND " +
            "disp.id.beginHour BETWEEN :begin AND :end AND " +
            "disp.office.id = :id")
    List<Disponibility> findByEndAndBegin(LocalDate moment, int begin, int end, Integer id);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"office", "bookings"})
    @Query("SELECT disp FROM Disponibility disp WHERE disp.office.id = :id AND :data = disp.id.moment AND " +
            "(:bool IS FALSE OR disp.isAvailable = :bool)")
    List<Disponibility> findAllByOffice(LocalDate data, Integer id, Boolean bool);

    @Query("SELECT new br.pedro.demofc.dtos.DayDTO(disp.id.moment) FROM Disponibility disp WHERE disp.office.id = :id GROUP BY disp.id.moment")
    List<DayDTO> findDaysOfDisponibilities(Integer id);
}