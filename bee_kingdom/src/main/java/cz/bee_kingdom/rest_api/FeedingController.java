package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.BeeColonyService;
import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.business.FeedingService;
import cz.bee_kingdom.business.FeedingTypeService;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.Feeding;
import cz.bee_kingdom.domain.FeedingType;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingDTO;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingToDto;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingToEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/colonies/{id_colony}/feeding")
public class FeedingController {
    private final FeedingService feedingService;
    private final BeeColonyService beeColonyService;
    private final FeedingToDto feedingToDto;
    private final FeedingToEntity feedingToEntity;
    private final FeedingTypeService feedingTypeService;

    public FeedingController(FeedingService feedingService, BeeColonyService beeColonyService, FeedingToDto feedingToDto, FeedingToEntity feedingToEntity, FeedingTypeService feedingTypeService) {
        this.feedingService = feedingService;
        this.beeColonyService = beeColonyService;
        this.feedingToDto = feedingToDto;
        this.feedingToEntity = feedingToEntity;
        this.feedingTypeService = feedingTypeService;
    }

    @PostMapping()
    public FeedingDTO create(@RequestBody FeedingDTO feedingDTO, @PathVariable Long id_colony) {
        Optional<BeeColony> tmp = beeColonyService.readByID(id_colony);

        if(tmp.isEmpty()) {
            throw new EntityStateException("Invalid Bee colony!");
        }
        feedingDTO.setIdBeeColony(tmp.get().getIdBeeColony());

        Optional<FeedingType> type = feedingTypeService.readByID(feedingDTO.getFeedingType());
        if(type.isEmpty()) {
            throw new EntityStateException("Invalid Feeding type!");
        }
        feedingDTO.setFeedingType(type.get().getID());

        return feedingToDto.apply(feedingService.create(feedingToEntity.apply(feedingDTO).setBeeColony(tmp.get()).setFeedingType(type.get())));
    }

    @GetMapping
    public Collection<FeedingDTO> readAll(@PathVariable Long id_colony) {
        return feedingService.readAllByBeeColony(id_colony);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody FeedingDTO feedingDTO, @PathVariable Long id_colony, @PathVariable Long id) {
        Optional<Feeding> tmp = feedingService.readByID(id);
        if(tmp.isEmpty()) {
            throw new EntityStateException("Invalid id to update!");
        }

        Optional<BeeColony> colony = beeColonyService.readByID(id_colony);
        if(colony.isEmpty()) {
            throw new EntityStateException("Invalid Bee Colony!");
        }

        Optional<FeedingType> type = feedingTypeService.readByID(feedingDTO.getFeedingType());
        if(type.isEmpty()) {
            throw new EntityStateException("Invalid Feeding type!");
        }

        tmp.get().setAmount(feedingDTO.getAmount());
        tmp.get().setBeeColony(colony.get());
        tmp.get().setFeedingType(type.get());
        tmp.get().setFeedingDate(feedingDTO.getFeedingDate());

        feedingService.update(tmp.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        feedingService.deleteById(id);
    }
}
