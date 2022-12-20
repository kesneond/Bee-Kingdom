package cz.bee_kingdom.client.model;
import java.sql.Date;

public class TreatmentDTO {
    public Date dateTime;

    public Long id;

    public Long idColony;

    public String idType;

    public TreatmentDTO() {}

    public TreatmentDTO(Date dateTime, Long idColony, String idType, Long id) {
        this.dateTime = dateTime;
        this.idColony = idColony;
        this.idType = idType;
        this.id = id;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

