package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Type;

public class ChairDTO {
    private Long id;
    private Type type;
    private boolean isAvailable;
    private Integer office_id;
    private String name;

    public ChairDTO(Chair chair, boolean isAvailable){
        this.id = chair.getId();
        this.type = chair.getType();
        this.office_id = chair.getOffice().getId();
        this.isAvailable = isAvailable;
        this.name = chair.getName();
    }

    public ChairDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Integer getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }
}
