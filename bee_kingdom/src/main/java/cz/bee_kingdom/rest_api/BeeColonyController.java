package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyDTO;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyToDto;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyToEntity;
import cz.bee_kingdom.business.BeeColonyService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/colonies")
public class BeeColonyController extends AbstractCrudController<BeeColony, BeeColonyDTO, Long> {

    BeeColonyController(BeeColonyService beeColonyService, BeeColonyToDto beeColonyToDto, BeeColonyToEntity beeColonyToEntity) {
        super(beeColonyService, beeColonyToDto, beeColonyToEntity);
    }

    @GetMapping("/{id}")
    public BeeColonyDTO getById(@PathVariable Long id) {
        Optional<BeeColony> tmp = super.service.readByID(id);
        if(tmp.isEmpty()){
            throw new EntityStateException("No Bee colony with name " + id);
        }
        return super.toDtoConverter.apply(tmp.get());
    }
}
