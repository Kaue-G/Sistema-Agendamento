package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {

    @Query("SELECT chair FROM Chair chair INNER JOIN chair.office office WHERE office.id = :id")
    Page<Chair> findByOffice(Pageable pageable, Integer id);

    @Query("SELECT chair FROM Chair chair WHERE chair.id = :id AND chair.office.id = :office")
    Chair findByIdAndOffice(Long id, Integer office);
}
