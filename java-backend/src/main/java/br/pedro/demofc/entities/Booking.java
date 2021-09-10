package br.pedro.demofc.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Booking", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueMomentAndEmployee", columnNames = {"MOMENT","EMPLOYEE_ID"})
})
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
