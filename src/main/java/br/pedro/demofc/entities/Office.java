package br.pedro.demofc.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OFFICE")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

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

    public int getLimit() {
        return 4;
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
