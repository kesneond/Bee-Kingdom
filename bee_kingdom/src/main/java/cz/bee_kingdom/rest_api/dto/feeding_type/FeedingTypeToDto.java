package cz.bee_kingdom.rest_api.dto.feeding_type;

import cz.bee_kingdom.domain.FeedingType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FeedingTypeToDto implements Function<FeedingType, FeedingTypeDTO> {
    @Override
    public FeedingTypeDTO apply(FeedingType feedingType) {
        FeedingTypeDTO tmp = new FeedingTypeDTO();
        tmp.setName(feedingType.getID());
        return tmp;
    }
}
