package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.LongBinaryOperator;

@Entity
public class FeedingType implements Serializable, DomainEntity<String> {

    @Id
    private String feedingTypeName;

    public FeedingType() {}

    public FeedingType(String feedingTypeName) {
        this.feedingTypeName = feedingTypeName;
    }

    public String getFeedingTypeName() {
        return feedingTypeName;
    }

    public void setFeedingTypeName(String feedingTypeName) {
        this.feedingTypeName = feedingTypeName;
    }

    @Override
    public String getID() {
        return feedingTypeName;
    }
}
