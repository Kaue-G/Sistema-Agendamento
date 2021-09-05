package br.pedro.demofc.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueMomentAndEmployee", columnNames = {"moment","employee_id"})
})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;

    private LocalDate moment;
    private int begin;

    @Column(name = "end_time")
    private int end;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
