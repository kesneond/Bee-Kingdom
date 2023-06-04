package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class TreatmentType implements Serializable, DomainEntity<String> {
    @Id
    private String treatmentTypeName;

    public TreatmentType() {
    }

    public TreatmentType(String treatmentTypeName) {
        this.treatmentTypeName = treatmentTypeName;
    }

    public String getTreatmentTypeName() {
        return treatmentTypeName;
    }

    public void setTreatmentTypeName(String treatmentTypeName) {
        this.treatmentTypeName = treatmentTypeName;
    }

    @Override
    public String getID() {
        return treatmentTypeName;
    }
}
