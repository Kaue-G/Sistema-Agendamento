package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.LocalDate;

@JsonInclude(Include.NON_NULL)
public class BookingDTO {

    private Integer id;
    private Type type;
    private Long chair;
    private LocalDate moment;
    private String employee_id;

    private Integer begin;
    private Integer end;

    public BookingDTO() {
    }

    public BookingDTO(Booking booking) {
        this.begin = booking.getBegin();
        this.end = booking.getEnd();
        this.moment = booking.getMoment();
        this.chair = booking.getChair().getId();
        this.employee_id = booking.getEmployee().getCpf();
        this.id = booking.getId();
    }

    public BookingDTO(Booking booking, LocalDate date, Type type, Long chair_id){
        this.id = booking.getId();
        this.employee_id = booking.getEmployee().getCpf();
        this.type = type;
        this.moment = date;
        this.chair = chair_id;
        if(type == Type.HOUR){
            this.begin = booking.getBegin();
            this.end = booking.getEnd();
        }
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
