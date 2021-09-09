package br.pedro.demofc.repositories;

import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.entities.Office;
import br.pedro.demofc.entities.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {

//    @Query("SELECT chair FROM Chair chair INNER JOIN chair.office office WHERE office.id = :id AND " +
//            "(COALESCE(:type) IS NULL OR chair.type = :type)")
//    Page<Chair> findByOffice(Pageable pageable, Integer id, Type type);

    @Query("SELECT chair FROM Chair chair INNER JOIN chair.office office WHERE office.id = :id")
    Page<Chair> findByOffice(Pageable pageable, Integer id);

    @EntityGraph(
            type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {
                    "office"
            }
    )
    @Query("SELECT chair FROM Chair chair WHERE chair.id = :id AND chair.office.id = :office")
    Chair findByIdAndOffice(Long id, Integer office);

    @Query("SELECT chair FROM Chair chair WHERE chair NOT IN(:disps)")
    List<Chair> findOnlyOne(List<Disponibility> disps);

    List<Chair> findByTypeAndOffice(Type type, Office office);

}
