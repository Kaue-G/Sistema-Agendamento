package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Disponibility;

import java.time.LocalDate;

public class DisponibilityDTO {

    private Integer office_id;
    private boolean isAvailable;
    private int amount;
    private LocalDate moment;
    private Integer beginHour;

    public DisponibilityDTO() {
    }

    public DisponibilityDTO(Disponibility disponibility) {
        this.moment = disponibility.getId().getMoment();
        this.beginHour = disponibility.getId().getBeginHour();
        this.amount = disponibility.getAmount();
        this.isAvailable = disponibility.isAvailable();
        this.office_id = disponibility.getOffice().getId();
    }

    public Integer getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public Integer getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(Integer beginHour) {
        this.beginHour = beginHour;
    }
}
