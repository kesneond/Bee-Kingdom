package cz.bee_kingdom.rest_api.dto.bee_colony;

import cz.bee_kingdom.domain.BeeColony;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class BeeColonyToEntity implements Function<BeeColonyDTO, BeeColony> {
    @Override
    public BeeColony apply(BeeColonyDTO beeColonyDTO) {
        return new BeeColony(beeColonyDTO.getName(), beeColonyDTO.getExtensionsNumber(), beeColonyDTO.getAvailability(), beeColonyDTO.getName());
    }
}
