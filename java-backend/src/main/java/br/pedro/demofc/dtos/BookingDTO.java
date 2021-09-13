package br.pedro.demofc.dtos;

import br.pedro.demofc.controllers.exceptions.BookingValid;
import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Type;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;

@JsonInclude(Include.NON_NULL)
@BookingValid
@ApiModel(value = "Booking", description = "Entidade que representa o corpo de um agendamento.")
public class BookingDTO {

    private String id;
    private Type type;

    private Long chair;

    @ApiModelProperty(required = true)
    private String moment;

    @ApiModelProperty(required = true)
    @Email(message = "Must be a email")
    private String employee_id;

    private Integer begin;
    private Integer end;
    private Integer weight;
    private String officeName;

    public BookingDTO() {
    }

    public BookingDTO(Booking booking, String date, Type type, Long chair_id){
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

    public BookingDTO(Booking booking, String officeName, String moment){
        this.id = booking.getId();
        this.moment = moment;
        this.weight = booking.getWeight();
        this.employee_id = booking.getEmployee().getEmail();
        this.begin = booking.getBegin();
        this.end = booking.getEnd();
        this.chair = booking.getRoom();
        this.officeName = officeName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getOfficeName() { return officeName; }

    public void setOfficeName(String officeName) { this.officeName = officeName; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
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
