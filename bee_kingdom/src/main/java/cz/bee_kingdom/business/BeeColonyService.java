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
    public BeeColony create(BeeColony entity) throws EntityStateException {
        if(entity.getID() == null || entity.getIdBeeColony() == null || entity.getAvailability() == null || entity.getExtensionsNumber() == null) {
            throw new EntityStateException();
        }
        if(entity.getID() != null && super.repository.existsById(entity.getID())) {
            throw new EntityStateException();
        }

        return super.repository.save(entity);
    }

    @Override
    public Iterable<BeeColony> readAll() {
        return super.repository.findAll().stream().sorted((BeeColony a, BeeColony b) -> { return (int)(a.getID()-b.getID());}).toList();
    }
}
