package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Office;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Integer> {

    @EntityGraph(
            type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {
                    "chairs"
            }
    )
    @Query("SELECT obj FROM Office obj INNER JOIN obj.chairs chairs WHERE obj = chairs.office")
    List<Office> findAllOffices();
}
