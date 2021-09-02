package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.entities.DisponibilityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DisponibilityRepository extends JpaRepository<Disponibility, DisponibilityPK> {

    @Query("SELECT disp FROM Disponibility disp WHERE disp.id.moment = :moment AND disp.id.beginHour BETWEEN :begin AND :end")
    List<Disponibility> findByEndAndBegin(LocalDate moment, int begin, int end);

    @Query("SELECT disp FROM Disponibility disp INNER JOIN disp.bookings books WHERE books.id = :id")
    List<Disponibility> findByBookingId(Integer id);
}
