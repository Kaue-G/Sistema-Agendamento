package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Disponibility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "Disponibility", description = "Disponibilidade de horário em determinada data")
public class DisponibilityDTO {

    @ApiModelProperty(value = "Escritório a qual pertence a disponibilidade")
    private Integer office_id;

    @ApiModelProperty(value = "Verificação de disponibilidade do horário")
    private boolean available;

    @ApiModelProperty(value = "Quantidade de reservas no horário")
    private int amount;

    @ApiModelProperty(value = "Data referente ao horário")
    private LocalDate moment;

    @ApiModelProperty(value = "Horário")
    private Integer beginHour;

    public DisponibilityDTO() {
    }

    public DisponibilityDTO(Disponibility disponibility) {
        this.moment = disponibility.getId().getMoment();
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
