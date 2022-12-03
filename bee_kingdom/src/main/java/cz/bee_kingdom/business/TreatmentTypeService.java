package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.TreatmentTypeRepository;
import cz.bee_kingdom.domain.TreatmentType;
import org.springframework.stereotype.Service;

@Service
public class TreatmentTypeService extends AbstractCrudService<TreatmentType, Long> {

    public TreatmentTypeService(TreatmentTypeRepository treatmentTypeRepository) { super(treatmentTypeRepository); }
}
