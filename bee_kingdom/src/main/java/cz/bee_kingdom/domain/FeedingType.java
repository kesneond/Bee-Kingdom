package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.LongBinaryOperator;

@Entity
public class FeedingType implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idFeedingType;

    private String feedingTypeName;

    @Override
    public Long getID() {
        return idFeedingType;
    }
}
