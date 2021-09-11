package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Disponibility;
import io.swagger.annotations.ApiModel;

import java.time.LocalDate;

@ApiModel(value = "Disponibility", description = "Entidade que representa uma disponibilidade de horário.")
public class DisponibilityDTO {

    private Integer office_id;
    private boolean available;
    private int amount;
    private String moment;
    private Integer beginHour;

    public DisponibilityDTO() {
    }

    public DisponibilityDTO(Disponibility disponibility, String moment) {
        this.moment = moment;
        this.beginHour = disponibility.getId().getBeginHour();
        this.amount = disponibility.getAmount();
        this.available = disponibility.isAvailable();
        this.office_id = disponibility.getOffice().getId();
    }

    public Integer getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public Integer getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(Integer beginHour) {
        this.beginHour = beginHour;
    }
}
