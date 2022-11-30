package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.rest_api.dto.BeeColonyDTO;
import cz.bee_kingdom.rest_api.dto.BeeColonyToDto;
import cz.bee_kingdom.rest_api.dto.BeeColonyToEntity;
import org.modelmapper.ModelMapper;
import cz.bee_kingdom.business.BeeColonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/colonies")
public class BeeColonyController extends AbstractCrudController<BeeColony, BeeColonyDTO, Long> {

    BeeColonyController(BeeColonyService beeColonyService, BeeColonyToDto beeColonyToDto, BeeColonyToEntity beeColonyToEntity) {
        super(beeColonyService, beeColonyToDto, beeColonyToEntity);
    }
}
