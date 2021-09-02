package br.pedro.demofc.dtos;

import br.pedro.demofc.entities.Booking;
import java.time.LocalDate;

public class BookingDTO {

    private Integer id;
    private Integer chair;
    private LocalDate moment;
    private int begin;
    private int end;
    private String employee_id;

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

    public BookingDTO(Integer id, Integer chair, LocalDate moment, int begin, int end, String employee_id) {
        this.id = id;
        this.chair = chair;
        this.moment = moment;
        this.begin = begin;
        this.end = end;
        this.employee_id = employee_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChair() {
        return chair;
    }

    public void setChair(Integer chair) {
        this.chair = chair;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
