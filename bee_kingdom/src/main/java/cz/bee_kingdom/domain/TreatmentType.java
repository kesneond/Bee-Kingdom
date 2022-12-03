package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class TreatmentType implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idTreatmentType;

    private String treatmentTypeName;

    public TreatmentType() {
    }

    public TreatmentType(String treatmentTypeName) {
        this.treatmentTypeName = treatmentTypeName;
    }

    public Long getIdTreatmentType() {
        return idTreatmentType;
    }

    public void setIdTreatmentType(Long idTreatmentType) {
        this.idTreatmentType = idTreatmentType;
    }

    public String getTreatmentTypeName() {
        return treatmentTypeName;
    }

    public void setTreatmentTypeName(String treatmentTypeName) {
        this.treatmentTypeName = treatmentTypeName;
    }

    @Override
    public Long getID() {
        return idTreatmentType;
    }
}
