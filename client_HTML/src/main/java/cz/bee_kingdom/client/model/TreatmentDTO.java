package cz.bee_kingdom.client.model;
import java.sql.Date;

public class TreatmentDTO {
    private Date dateTime;


    private Long idColony;

    private String idType;

    public TreatmentDTO() {}

    public TreatmentDTO(Date dateTime, Long idColony, String idType) {
        this.dateTime = dateTime;
        this.idColony = idColony;
        this.idType = idType;
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

