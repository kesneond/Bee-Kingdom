package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyDTO;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyToDto;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyToEntity;
import cz.bee_kingdom.business.BeeColonyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colonies")
public class BeeColonyController extends AbstractCrudController<BeeColony, BeeColonyDTO, Long> {

    BeeColonyController(BeeColonyService beeColonyService, BeeColonyToDto beeColonyToDto, BeeColonyToEntity beeColonyToEntity) {
        super(beeColonyService, beeColonyToDto, beeColonyToEntity);
    }


}
