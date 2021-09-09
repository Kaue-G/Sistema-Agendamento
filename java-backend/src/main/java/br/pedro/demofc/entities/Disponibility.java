package br.pedro.demofc.entities;

import br.pedro.demofc.entities.pk.DisponibilityPK;

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
    @JoinColumn (name = "OFFICE_PK")
    private Office office;

    @Column(name = "IS_AVAILABLE")
    private boolean isAvailable;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Disponibility_Booking",
            joinColumns = {@JoinColumn (name = "HOUR_ID"), @JoinColumn (name = "MOMENT_ID"), @JoinColumn (name = "OFFICE_ID")},
            inverseJoinColumns = @JoinColumn(name = "BOOKING_ID"))
    private final Set<Booking> bookings = new HashSet<>();

//    @ManyToMany(mappedBy = "disponibilities", cascade = CascadeType.ALL)
//    private final Set<Booking> bookings = new HashSet<>();

    public Disponibility() {
    }

    public void tryAvailable(float percentage){
        this.isAvailable = bookings.size() < this.getOffice().getCapacity() * (percentage/100);
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
