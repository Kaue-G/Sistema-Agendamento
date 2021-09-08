package br.pedro.demofc.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Booking", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueMomentAndEmployee", columnNames = {"MOMENT","EMPLOYEE_ID"})
})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne
    @Column(name = "CHAIR_ID")
    private Long chair;

    private LocalDate moment;

    @Column(name = "BEGIN_TIME")
    private int begin;

    @Column(name = "END_TIME")
    private int end;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
