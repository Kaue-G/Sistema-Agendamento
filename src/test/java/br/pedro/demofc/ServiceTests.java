package br.pedro.demofc;

import br.pedro.demofc.dtos.DayDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class ServiceTests {

    @Test
    void dataDTOTestArguments(){
        LocalDate date = LocalDate.of(2021,7,14);
        DayDTO day = new DayDTO(date);

        System.out.println(day.getDay());
        System.out.println(day.getVerbose());
    }
}
