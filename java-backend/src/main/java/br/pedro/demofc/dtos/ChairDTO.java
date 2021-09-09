package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Chair;
import br.pedro.demofc.entities.Type;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Chair", description = "Dado sobre cadeira ou sala disponível no banco de dados")
public class ChairDTO {

    @ApiModelProperty(value = "Identificador")
    private Long id;

    @ApiModelProperty(value = "Tipo do local de trabalho: uma mesa ou sala")
    private Type type;

    @ApiModelProperty(value = "Verificação da disponibilidade")
    private boolean isAvailable;

    @ApiModelProperty(value = "Escritório a qual pertence")
    private Integer office_id;

    @ApiModelProperty(value = "Verbose")
    private String name;

    private int bookingAmount;

    public ChairDTO(Chair chair, boolean isAvailable){
        this.id = chair.getId();
        this.type = chair.getType();
        this.office_id = chair.getOffice().getId();
        this.isAvailable = isAvailable;
        this.name = chair.getName();
        //this.bookingAmount = chair.getBookingAmount();
    }

    public ChairDTO() {
    }

    public int getBookingsAmount() {
        return bookingAmount;
    }

    public void setBookingsAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
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
