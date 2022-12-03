package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Treatment implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idTreat;

    private Date dateTime;

    @ManyToOne
    private TreatmentType treatmentType;

    @ManyToOne
    private BeeColony colony;

//    private Long idColony;
//
//    private Long idType;

//    public Long getIdColony() {
//        return idColony;
//    }
//
//    public void setIdColony(Long idColony) {
//        this.idColony = idColony;
//    }
//
//    public Long getIdType() {
//        return idType;
//    }
//
//    public void setIdType(Long idType) {
//        this.idType = idType;
//    }

    public Treatment(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Treatment() {
    }

    @Override
    public Long getID() {
        return idTreat;
    }

    public Long getIdTreat() {
        return idTreat;
    }

    public void setIdTreat(Long idTreat) {
        this.idTreat = idTreat;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public Treatment setTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = treatmentType;
        return this;
    }

    public BeeColony getColony() {
        return colony;
    }

    public Treatment setColony(BeeColony colony) {
        this.colony = colony;
        return this;
    }
}
