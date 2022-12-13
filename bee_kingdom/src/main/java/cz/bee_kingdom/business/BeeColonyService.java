package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.BeeColonyRepository;
import cz.bee_kingdom.domain.BeeColony;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BeeColonyService extends AbstractCrudService<BeeColony, Long> {

    public BeeColonyService( BeeColonyRepository repository ) {
        super(repository);
    }

    @Override
    public Iterable<BeeColony> readAll() {
        return super.repository.findAll().stream().sorted((BeeColony a, BeeColony b) -> { return (int)(a.getID()-b.getID());}).toList();
    }
}
