package br.pedro.demofc;

import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.repositories.ChairRepository;
import br.pedro.demofc.repositories.DisponibilityRepository;
import br.pedro.demofc.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

@DataJpaTest
public class DataTests {

    @Autowired
    private ChairRepository cRepository;

    @Autowired
    private DisponibilityRepository dRepository;

    @Autowired
    private EmployeeRepository eRepository;

    private int validOffice;
    private int invalidOffice;
    private LocalDate validDate;

    @BeforeEach
    void setUp(){
        validOffice = 1;
        invalidOffice = 10;
        validDate = LocalDate.of(2020,7,21);
    }


    @Test
    void findChairsByOfficeShouldReturnPagedWhenOfficeIdExists(){
        PageRequest request = PageRequest.of(0,5, Sort.by("id"));
        Page<Chair> chairs = cRepository.findByOffice(request,validOffice);

        Assertions.assertFalse(chairs.isEmpty());
        Assertions.assertEquals(chairs.getContent().get(2).getId(),3);
    }

    @Test
    void findChairsByOfficeShouldReturnEmptyWhenOfficeNonExistent(){
        PageRequest request = PageRequest.of(0,5, Sort.by("id"));
        Page<Chair> chairs = cRepository.findByOffice(request,invalidOffice);

        Assertions.assertTrue(chairs.isEmpty());
        Assertions.assertEquals(chairs.getTotalElements(),0);
    }

    @Test
    void findDisponibilitiesByOfficeShouldReturnPagedWhenOfficeIdExists(){
        PageRequest request = PageRequest.of(0,10, Sort.by("id.moment"));
        Page<Disponibility> disponibilities = dRepository.findAllByOffice(request,null,validOffice,null);

        disponibilities.forEach(disp -> System.out.println(disp.getId().getMoment()));

        Assertions.assertFalse(disponibilities.isEmpty());
        disponibilities.forEach(disp -> Assertions.assertEquals(disp.getOffice().getId(),validOffice));
    }

    @Test
    void findDisponibilitiesByOfficeShouldReturnEmptyWhenOfficeNonExistent(){
        PageRequest request = PageRequest.of(0,5, Sort.by("id.moment"));
        Page<Disponibility> disponibilities = dRepository.findAllByOffice(request,null,invalidOffice,null);

        Assertions.assertTrue(disponibilities.isEmpty());
    }

    @Test
    void findDisponibilitiesByOfficeShouldFilterByDate(){
        PageRequest request = PageRequest.of(0,5, Sort.by("id.moment"));
        Page<Disponibility> disponibilities = dRepository.findAllByOffice(request, validDate, invalidOffice,null);

        disponibilities.forEach(disp -> Assertions.assertEquals(disp.getId().getMoment(),validDate));
    }

    @Test
    void findDisponibilitiesByOfficeShouldFilterByAvailable(){
        PageRequest request = PageRequest.of(0,5, Sort.by("id.moment"));
        Page<Disponibility> disponibilities = dRepository.findAllByOffice(request,null,validOffice,true);

        disponibilities.forEach(disp -> Assertions.assertTrue(disp.isAvailable()));
    }
}
