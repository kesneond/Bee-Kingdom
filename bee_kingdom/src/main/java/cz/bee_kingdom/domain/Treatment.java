package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Treatment implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idTreat;

    private LocalDateTime dateTime;

    @ManyToOne
    TreatmentType treatmentType;

    @ManyToOne
    BeeColony colony;

    @Override
    public Long getID() {
        return idTreat;
    }
}
