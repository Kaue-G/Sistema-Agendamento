package br.pedro.demofc.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Disponibility")
public class Disponibility {

    @EmbeddedId
    private DisponibilityPK id;

    @ManyToOne
    @MapsId ("office_id")
    @JoinColumn (name = "office_pk")
    private Office office;

    private boolean isAvailable;

    @ManyToMany
    @JoinTable(name = "tb_disp_booking",
            joinColumns = {@JoinColumn (name = "begin_id"), @JoinColumn (name = "moment_id"), @JoinColumn (name = "office_id")},
            inverseJoinColumns = @JoinColumn(name = "booking_id"))
    private final Set<Booking> bookings = new HashSet<>();

//    @ManyToMany(mappedBy = "disponibilities", cascade = CascadeType.ALL)
//    private final Set<Booking> bookings = new HashSet<>();

    public Disponibility() {
    }

    public void tryAvailable(){
        this.isAvailable = bookings.size() < this.getOffice().getLimit();
    }

    public DisponibilityPK getId() {
        return id;
    }

    public void setId(DisponibilityPK id) {
        this.id = id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public boolean isAvailable() {
        tryAvailable();
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getAmount() {
        return bookings.size();
    }

    public Set<Booking> getBookings() {
        return bookings;
    }
}
