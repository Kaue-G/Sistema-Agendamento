package br.pedro.demofc.entities;

import javax.persistence.*;

@Entity
@Table(name = "Chair")
public class Chair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String local;

    @ManyToOne
    @JoinColumn(name = "OFFICE_ID")
    private Office office;

    public Chair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
