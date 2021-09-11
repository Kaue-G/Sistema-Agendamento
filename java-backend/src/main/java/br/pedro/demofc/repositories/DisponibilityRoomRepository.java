package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.DisponibilityRoom;
import br.pedro.demofc.entities.pk.DisponibilityRoomPK;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DisponibilityRoomRepository extends JpaRepository<DisponibilityRoom, DisponibilityRoomPK> {

    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"room"})
    List<DisponibilityRoom> findAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"room"})
    @Query("SELECT dr FROM DisponibilityRoom dr WHERE dr.id.disponibilityPK.moment = :moment AND " +
            "dr.id.disponibilityPK.beginHour BETWEEN :begin AND :end AND " +
            "dr.id.disponibilityPK.office_id = :id")
    List<DisponibilityRoom> findByEndAndBegin(LocalDate moment, int begin, int end, Integer id);

}
