package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OfficeRepository extends JpaRepository<Office,Integer> {
}
