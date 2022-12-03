package cz.bee_kingdom.rest_api.dto.feeding;

import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.FeedingType;
import lombok.Data;

import java.sql.Date;

@Data
public class FeedingDTO {
    private Date feedingDate;
    private Long amount;
    private Long idBeeColony;
    private String feedingType;

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

    public Long getIdBeeColony() {
        return idBeeColony;
    }

    public void setIdBeeColony(Long idBeeColony) {
        this.idBeeColony = idBeeColony;
    }

    public String getFeedingType() {
        return feedingType;
    }

    public void setFeedingType(String feedingType) {
        this.feedingType = feedingType;
    }
}
