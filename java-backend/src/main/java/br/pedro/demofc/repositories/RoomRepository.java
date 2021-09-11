package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.entities.DisponibilityRoom;
import br.pedro.demofc.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT room FROM Room room INNER JOIN room.office office WHERE office.id = :id")
    Page<Room> findByOffice(Pageable pageable, Integer id);

    @Query("SELECT room FROM Room room WHERE room.id = :id AND room.office.id = :office")
    Room findByIdAndOffice(Long id, Integer office);
}
