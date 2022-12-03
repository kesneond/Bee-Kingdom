package cz.bee_kingdom.rest_api.dto.treatment;

import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.TreatmentType;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class TreatmentDTO {
    private Date dateTime;

//    private TreatmentType treatmentType;

//    private BeeColony colony;

    private Long idColony;

    private Long idType;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

//    public TreatmentType getTreatmentType() {
//        return treatmentType;
//    }

//    public void setTreatmentType(TreatmentType treatmentType) {
//        this.treatmentType = treatmentType;
//    }

//    public BeeColony getColony() {
//        return colony;
//    }

//    public void setColony(BeeColony colony) {
//        this.colony = colony;
//    }


    public Long getIdColony() {
        return idColony;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "TreatmentDTO{" +
                "dateTime=" + dateTime +
                ", treatmentType=" + idType +
                ", idColony=" + idColony +
                '}';
    }

    public void setIdColony(Long idColony) {
        this.idColony = idColony;
    }
}
