package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.FeedingRepository;
import cz.bee_kingdom.domain.Feeding;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingDTO;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingToDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FeedingService extends AbstractCrudService<Feeding, Long> {

    private final FeedingRepository feedingRepository;
    private final FeedingToDto feedingToDto;

    public FeedingService(FeedingRepository feedingRepository, FeedingToDto feedingToDto) {
        super(feedingRepository);
        this.feedingRepository = feedingRepository;
        this.feedingToDto = feedingToDto;
    }

    public Collection<FeedingDTO> readAllByBeeColony(Long id) {
        ArrayList<Feeding> tmp = feedingRepository.findAllByBeeColonyIdBeeColony(id);
        ArrayList<FeedingDTO> res = new ArrayList<FeedingDTO>();

        for( var elem : tmp ) {
            res.add(feedingToDto.apply(elem));
        }

        return res;
    }
}
