package br.pedro.demofc.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class DisponibilityPK implements Serializable {

    @Column(name = "moment_pk",columnDefinition = "DATETIME")
    private LocalDate moment;

    @Column(name = "begin_pk")
    private Integer beginHour;

    @JoinColumn(name = "office_pk")
    private Integer office_id;

    public DisponibilityPK() {
    }

    public DisponibilityPK(LocalDate moment, Integer beginHour) {
        this.moment = moment;
        this.beginHour = beginHour;
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
