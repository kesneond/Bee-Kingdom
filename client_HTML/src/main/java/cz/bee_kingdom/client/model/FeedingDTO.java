package cz.bee_kingdom.client.model;

import java.sql.Date;

public class FeedingDTO {
    public Long id;
    public Date feedingDate;
    public Long amount;
    public Long idBeeColony;
    public String feedingType;

    public FeedingDTO(Long id, Date feedingDate, Long amount, Long idColony, String feedingType) {
        this.id = id;
        this.feedingDate = feedingDate;
        this.amount = amount;
        this.idBeeColony = idColony;
        this.feedingType = feedingType;
    }

    public FeedingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdColony() {
        return idBeeColony;
    }

    public void setIdColony(Long idColony) {
        this.idBeeColony = idColony;
    }

    public String getFeedingType() {
        return feedingType;
    }

    public void setFeedingType(String feedingType) {
        this.feedingType = feedingType;
    }
}
