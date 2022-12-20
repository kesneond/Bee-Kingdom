package cz.bee_kingdom.rest_api.dto.treatment;

import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.TreatmentType;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class TreatmentDTO {
    private Date dateTime;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long idColony;

    private String idType;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getIdColony() {
        return idColony;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
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
