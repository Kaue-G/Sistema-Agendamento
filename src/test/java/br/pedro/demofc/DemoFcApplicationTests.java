package br.pedro.demofc;

import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.repositories.ChairRepository;
import br.pedro.demofc.repositories.DisponibilityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

@DataJpaTest
class DemoFcApplicationTests {

    @Autowired
    private ChairRepository repository;

    @Autowired
    private DisponibilityRepository dispRep;

    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Chair> chairPage = repository.findByOffice(pageRequest,1);

        chairPage.forEach(c -> System.out.println(c.getId()));
    }

    @Test
    void searchShouldReturnPagedOfAllWhenDataIsNull(){
        PageRequest pageRequest = PageRequest.of(0,10);
        Page<Disponibility> disponibilities = dispRep.findAllByOffice(pageRequest,1, null,true);

        disponibilities.forEach(x -> System.out.println(x.getId().getBeginHour() + "," + x.getOffice().getId()));


    }

    @Test
    void searchShouldReturnPagedOfDataWhenDataExists(){

    }


}
