package br.pedro.demofc.entities;

import org.springframework.beans.factory.annotation.Value;

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

    @OneToMany(mappedBy = "office")
    private final List<Chair> chairs = new ArrayList<>();

    @OneToMany(mappedBy = "office")
    private final List<Disponibility> disponibilities = new ArrayList<>();

    public Office() {
    }

    public Office(Integer id, String name) {
        this.id = id;
        this.name = name;
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
