package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.DisponibilityRoom;
import br.pedro.demofc.entities.pk.DisponibilityRoomPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilityRoomRepository extends JpaRepository<DisponibilityRoom, DisponibilityRoomPK> {

}
