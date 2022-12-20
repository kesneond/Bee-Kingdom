package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.FeedingTypeRepository;
import cz.bee_kingdom.domain.FeedingType;
import org.springframework.stereotype.Service;

@Service
public class FeedingTypeService extends AbstractCrudService<FeedingType, String> {

    public FeedingTypeService(FeedingTypeRepository feedingTypeRepository) { super(feedingTypeRepository); }
}
