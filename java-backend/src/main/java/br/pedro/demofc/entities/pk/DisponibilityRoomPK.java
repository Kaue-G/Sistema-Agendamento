package br.pedro.demofc.entities.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DisponibilityRoomPK implements Serializable {

    private DisponibilityPK disponibilityPK = new DisponibilityPK();

    @Column(name = "ROOM_PK")
    private Long room;

    public DisponibilityRoomPK() {
    }

    public DisponibilityRoomPK(DisponibilityPK disponibilityPK, Long room) {
        this.disponibilityPK = disponibilityPK;
        this.room = room;
    }

    public DisponibilityPK getDisponibilityPK() {
        return disponibilityPK;
    }

    public void setDisponibilityPK(DisponibilityPK disponibilityPK) {
        this.disponibilityPK = disponibilityPK;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long chair) {
        this.room = chair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilityRoomPK that = (DisponibilityRoomPK) o;
        return disponibilityPK.equals(that.disponibilityPK) && room.equals(that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponibilityPK, room);
    }
}
