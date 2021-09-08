package br.pedro.demofc.dtos;

import java.util.ArrayList;
import java.util.List;

public class OfficeDTO {

    private Integer id;
    private String name;

    private final List<DayDTO> days = new ArrayList<>();

    public OfficeDTO() {
    }

    public OfficeDTO(Integer id, String name, List<DayDTO> days){
        this.id = id;
        this.name = name;
        this.days.addAll(days);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DayDTO> getDays() {
        return days;
    }
}
