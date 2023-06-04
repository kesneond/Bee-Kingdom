package cz.bee_kingdom.rest_api.dto.feeding;

import cz.bee_kingdom.domain.Feeding;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FeedingToEntity implements Function<FeedingDTO, Feeding> {

    @Override
    public Feeding apply(FeedingDTO feedingDTO) {
        return new Feeding(feedingDTO.getFeedingDate(), feedingDTO.getAmount());
    }
}
