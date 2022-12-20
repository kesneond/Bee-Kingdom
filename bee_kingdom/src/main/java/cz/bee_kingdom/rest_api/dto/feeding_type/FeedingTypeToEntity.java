package cz.bee_kingdom.rest_api.dto.feeding_type;

import cz.bee_kingdom.domain.FeedingType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FeedingTypeToEntity implements Function<FeedingTypeDTO, FeedingType> {
    @Override
    public FeedingType apply(FeedingTypeDTO feedingTypeDTO) {
        return new FeedingType(feedingTypeDTO.getName());
    }
}
