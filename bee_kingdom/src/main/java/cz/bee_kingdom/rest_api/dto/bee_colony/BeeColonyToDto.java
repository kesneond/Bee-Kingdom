package cz.bee_kingdom.rest_api.dto.bee_colony;

import cz.bee_kingdom.domain.BeeColony;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class BeeColonyToDto implements Function<BeeColony, BeeColonyDTO> {
    @Override
    public BeeColonyDTO apply(BeeColony beeColony) {
        BeeColonyDTO ret = new BeeColonyDTO();
        ret.setExtensionsNumber(beeColony.getExtensionsNumber());
        ret.setAvailability(beeColony.getAvailability());
        ret.setName(beeColony.getName());
        return ret;
    }
}
