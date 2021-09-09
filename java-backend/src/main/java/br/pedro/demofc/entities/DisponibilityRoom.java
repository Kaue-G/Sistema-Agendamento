package br.pedro.demofc.entities;

import br.pedro.demofc.entities.pk.DisponibilityRoomPK;

import javax.persistence.*;

@Entity
@Table(name = "DISPONIBILITY_ROOM")
public class DisponibilityRoom {

    @EmbeddedId
    private DisponibilityRoomPK primaryKey;

    @ManyToOne
    @MapsId ("chair")
    @JoinColumn (name = "CHAIR_PK")
    private Chair chair;

    private int capacity;

    public DisponibilityRoom() {
    }

    public DisponibilityRoom(Disponibility disponibility, Chair chair) {
        this.primaryKey = new DisponibilityRoomPK(disponibility.getId(), chair.getId());
        this.chair = chair;
    }

    public void addBooking(){
        this.capacity++;
    }

    public void remBooking(){
        this.capacity--;
    }

    public DisponibilityRoomPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(DisponibilityRoomPK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
