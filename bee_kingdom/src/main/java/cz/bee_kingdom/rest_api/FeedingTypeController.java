package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.FeedingTypeService;
import cz.bee_kingdom.domain.FeedingType;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingToDto;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingToEntity;
import cz.bee_kingdom.rest_api.dto.feeding_type.FeedingTypeDTO;
import cz.bee_kingdom.rest_api.dto.feeding_type.FeedingTypeToDto;
import cz.bee_kingdom.rest_api.dto.feeding_type.FeedingTypeToEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/feeding_type")
@RestController
public class FeedingTypeController extends AbstractCrudController<FeedingType, FeedingTypeDTO, String> {

    public FeedingTypeController(FeedingTypeService feedingTypeService, FeedingTypeToDto feedingToDto, FeedingTypeToEntity feedingToEntity) {
        super(feedingTypeService, feedingToDto, feedingToEntity);
    }

    @PutMapping("/{id}")
    @Override
    public void update(@RequestBody FeedingTypeDTO e, @PathVariable String id) {
        super.delete(id);
        super.create(e);
    }
}
