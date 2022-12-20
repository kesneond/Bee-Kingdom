package cz.bee_kingdom.rest_api.dto.feeding;

import cz.bee_kingdom.domain.Feeding;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FeedingToDto implements Function<Feeding, FeedingDTO> {

    @Override
    public FeedingDTO apply(Feeding feeding) {
        FeedingDTO tmp = new FeedingDTO();
        tmp.setAmount(feeding.getAmount());
        tmp.setFeedingDate(feeding.getFeedingDate());
        tmp.setFeedingType(feeding.getFeedingType().getID());
        tmp.setIdBeeColony(feeding.getBeeColony().getID());
        tmp.setId(feeding.getID());

        return tmp;
    }
}
