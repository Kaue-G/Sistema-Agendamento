package br.pedro.demofc.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Booking", uniqueConstraints = {@UniqueConstraint(name = "uniqueMomentAndEmployee", columnNames = {"MOMENT","EMPLOYEE_ID"})})
@GenericGenerator(name = "booking-gen", parameters = {@Parameter(name = "prefix", value = "FC")}, strategy = "br.pedro.demofc.services.IdGenerator")
public class Booking {

    @Id
    @GeneratedValue(generator = "booking-gen")
    private String id;

    @Column(name = "ROOM")
    private Long room;

    private LocalDate moment;

    @Column(name = "BEGIN_TIME")
    private int begin;

    @Column(name = "END_TIME")
    private int end;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    private Integer weight;

    @ManyToMany(mappedBy = "bookings")
    private final Set<Disponibility> disponibilities = new HashSet<>();

    public Booking() {
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long chair) {
        this.room = chair;
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

    public Set<Disponibility> getDisponibilities() {
        return disponibilities;
    }
}
