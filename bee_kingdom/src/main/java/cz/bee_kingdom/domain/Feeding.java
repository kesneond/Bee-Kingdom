package cz.bee_kingdom.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Feeding implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idFeeding;

    private Date feedingDate;
    private Long amount;

    @ManyToOne
    BeeColony beeColony;

    @ManyToOne
    FeedingType feedingType;

    public Feeding(Date feedingDate, Long amount) {
        this.feedingDate = feedingDate;
        this.amount = amount;
    }

    public Feeding() {}

    public Long getIdFeeding() {
        return idFeeding;
    }

    public Date getFeedingDate() {
        return feedingDate;
    }

    public void setFeedingDate(Date feedingDate) {
        this.feedingDate = feedingDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BeeColony getBeeColony() {
        return beeColony;
    }

    public Feeding setBeeColony(BeeColony beeColony) {
        this.beeColony = beeColony;
        return this;
    }

    public FeedingType getFeedingType() {
        return feedingType;
    }

    public Feeding setFeedingType(FeedingType feedingType) {
        this.feedingType = feedingType;
        return this;
    }

    @Override
    public Long getID() {
        return idFeeding;
    }
}
