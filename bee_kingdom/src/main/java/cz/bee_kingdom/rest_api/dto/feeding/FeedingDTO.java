package cz.bee_kingdom.rest_api.dto.feeding;

import lombok.Data;

import java.sql.Date;

@Data
public class FeedingDTO {
    private Long id;
    private Date feedingDate;
    private Long amount;
    private Long idBeeColony;
    private String feedingType;
}
