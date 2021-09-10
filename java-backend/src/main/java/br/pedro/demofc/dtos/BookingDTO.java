package br.pedro.demofc.dtos;

import br.pedro.demofc.controllers.exceptions.BookingValid;
import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.time.LocalDate;

@JsonInclude(Include.NON_NULL)
@BookingValid
@ApiModel(value = "Booking", description = "Agendamento")
public class BookingDTO {

    @ApiModelProperty(value = "Identificador do agendamento")
    private Integer id;

    @ApiModelProperty(value = "Tipo do agendamento para definir entre dia completo 'DAY' ou intervalo de horário 'REUNION'")
    private Type type;

    @ApiModelProperty(value = "Local de trabalho", required = true)
    private Long chair;

    @ApiModelProperty(value = "Data do agendamento", required = true)
    private LocalDate moment;

    @ApiModelProperty(value = "Usuário relacionado ao agendamento", required = true)
    private String employee_id;

    @ApiModelProperty(value = "Horário de início do agendamento")
    private Integer begin;

    @ApiModelProperty(value = "Horário de término do agendamento")
    private Integer end;

    private Integer weight;

    public BookingDTO() {
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BookingDTO(Booking booking, LocalDate date, Type type, Long chair_id){
        this.id = booking.getId();
        this.employee_id = booking.getEmployee().getCpf();
        this.type = type;
        this.moment = date;
        if(type == Type.REUNION){
            this.begin = booking.getBegin();
            this.end = booking.getEnd();
            this.chair = chair_id;
        }
    }

    public BookingDTO(Booking booking){
        this.id = booking.getId();
        this.moment = booking.getMoment();
        this.weight = booking.getWeight();
        this.employee_id = booking.getEmployee().getCpf();
        this.begin = booking.getBegin();
        this.end = booking.getEnd();
        this.chair = booking.getChair();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getChair() {
        return chair;
    }

    public void setChair(Long chair) {
        this.chair = chair;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
