package br.pedro.demofc.entities.pk;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class DisponibilityPK implements Serializable {

    @Column(name = "DATE_PK")
    private LocalDate moment;

    @Column(name = "HOUR_PK")
    private Integer beginHour;

    @Column(name = "OFFICE_PK")
    private Integer office_id;

    public DisponibilityPK() {
    }

    public DisponibilityPK(LocalDate moment, Integer beginHour, Integer office_id) {
        this.moment = moment;
        this.beginHour = beginHour;
        this.office_id = office_id;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public Integer getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(Integer beginHour) {
        this.beginHour = beginHour;
    }

    public Integer getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilityPK that = (DisponibilityPK) o;
        return moment.equals(that.moment) && beginHour.equals(that.beginHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moment, beginHour);
    }
}
