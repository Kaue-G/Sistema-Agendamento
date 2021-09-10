package br.pedro.demofc.entities.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DisponibilityRoomPK implements Serializable {

    private DisponibilityPK disponibilityPK = new DisponibilityPK();

    @Column(name = "CHAIR_PK")
    private Long chair;

    public DisponibilityRoomPK() {
    }

    public DisponibilityRoomPK(DisponibilityPK disponibilityPK, Long chair) {
        this.disponibilityPK = disponibilityPK;
        this.chair = chair;
    }

    public DisponibilityPK getDisponibilityPK() {
        return disponibilityPK;
    }

    public void setDisponibilityPK(DisponibilityPK disponibilityPK) {
        this.disponibilityPK = disponibilityPK;
    }

    public Long getChair() {
        return chair;
    }

    public void setChair(Long chair) {
        this.chair = chair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilityRoomPK that = (DisponibilityRoomPK) o;
        return disponibilityPK.equals(that.disponibilityPK) && chair.equals(that.chair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponibilityPK, chair);
    }
}
