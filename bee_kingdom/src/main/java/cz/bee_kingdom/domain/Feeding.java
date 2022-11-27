package cz.bee_kingdom.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Feeding implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idFeeding;

    private LocalDateTime feedingDate;
    private Long amount;

    @ManyToOne
    BeeColony beeColony;

    @ManyToOne
    FeedingType feedingType;

    @Override
    public Long getID() {
        return idFeeding;
    }
}
