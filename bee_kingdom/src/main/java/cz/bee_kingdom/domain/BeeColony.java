package cz.bee_kingdom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class BeeColony implements Serializable, DomainEntity<Long> {
    @Id
//    @GeneratedValue
    private Long idBeeColony;
    private Long extensionsNumber;
    private Long availability;
    private Long name;

//    @OneToMany
//    private ArrayList<Treatment> treatments;
//
//    public ArrayList<Treatment> getTreatments() {
//        return treatments;
//    }
//
//    public void setTreatments(Treatment treatments) {
//        this.treatments.add(treatments);
//    }

    public BeeColony(Long id, Long extensionsNumber, Long availability, Long name ) {
        this.idBeeColony = id;
        this.extensionsNumber = extensionsNumber;
        this.availability = availability;
        this.name = name;
    }
    public BeeColony() {}

    @Override
    public Long getID() {
        return idBeeColony;
    }

    public void setIdBeeColony(Long idBeeColony) {
        this.idBeeColony = idBeeColony;
    }

    public void setExtensionsNumber(Long extensionsNumber) {
        this.extensionsNumber = extensionsNumber;
    }

    public Long getIdBeeColony() {
        return idBeeColony;
    }

    public Long getExtensionsNumber() {
        return extensionsNumber;
    }

    public Long getAvailability() {
        return availability;
    }

    public Long getName() {
        return name;
    }

    public void setAvailability(Long availability) {
        this.availability = availability;
    }

    public void setName(Long name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeeColony{" +
                "idBeeColony=" + idBeeColony +
                ", extensionsNumber=" + extensionsNumber +
                ", availability=" + availability +
                ", name=" + name +
                '}';
    }
}
