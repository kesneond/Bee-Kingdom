package cz.bee_kingdom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class BeeColony implements Serializable, DomainEntity<Long> {
    @Id
    private Long idBeeColony;
    private Long extensionsNumber;
    private Long availability;

    @Override
    public Long getID() {
        return idBeeColony;
    }
}
