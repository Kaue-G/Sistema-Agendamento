package br.pedro.demofc.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int capacity;
    private String address;

    @OneToMany(mappedBy = "office")
    private final List<Disponibility> disponibilities = new ArrayList<>();

    @OneToMany(mappedBy = "office")
    private final List<Chair> chairs = new ArrayList<>();

    public Office() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Disponibility> getDisponibilities() {
        return disponibilities;
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
