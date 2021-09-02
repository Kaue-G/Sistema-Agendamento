package br.pedro.demofc.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    private String cpf;
    private String email;
    private String businessUnit;

    @OneToMany(mappedBy = "employee")
    private final List<Booking> bookings = new ArrayList<>();

    public Employee() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
}
