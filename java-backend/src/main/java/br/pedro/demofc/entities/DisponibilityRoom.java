package br.pedro.demofc.entities;

import br.pedro.demofc.entities.pk.DisponibilityRoomPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DISPONIBILITY_ROOM")
public class DisponibilityRoom {

    @EmbeddedId
    private DisponibilityRoomPK id;

    @ManyToOne
    @MapsId ("room")
    @JoinColumn (name = "ROOM_PK")
    private Room room;

    private int capacity;

    public DisponibilityRoom() {
    }

    public DisponibilityRoom(Disponibility disponibility, Room room) {
        this.id = new DisponibilityRoomPK(disponibility.getId(), room.getId());
        this.room = room;
    }

    public void addBooking(int weight){
        capacity += weight;
    }

    public void remBooking(int weight) {
        capacity -= weight;
    }

    public DisponibilityRoomPK getId() {
        return id;
    }

    public void setId(DisponibilityRoomPK primaryKey) {
        this.id = primaryKey;
    }

    public Room getChair() {
        return room;
    }

    public void setChair(Room room) {
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilityRoom that = (DisponibilityRoom) o;
        return id.equals(that.id) && room.equals(that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room);
    }
}
