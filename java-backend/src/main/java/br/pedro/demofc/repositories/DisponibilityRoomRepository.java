package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.DisponibilityRoom;
import br.pedro.demofc.entities.pk.DisponibilityRoomPK;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilityRoomRepository extends JpaRepository<DisponibilityRoom, DisponibilityRoomPK> {

    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"room"})
    List<DisponibilityRoom> findAll();

}
