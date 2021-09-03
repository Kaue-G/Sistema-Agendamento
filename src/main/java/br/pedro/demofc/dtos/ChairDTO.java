package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Chair;

public class ChairDTO {
    private Long id;
    private String local;
    private boolean isAvailable;
    private Integer office_id;

    public ChairDTO(Chair chair){
        this.id = chair.getId();
        this.local = chair.getLocal();
        this.office_id = chair.getOffice().getId();
        this.isAvailable = chair.isAvailable();
    }

    public ChairDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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
