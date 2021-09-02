package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Integer> {
}
