package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.TreatmentRepository;
import cz.bee_kingdom.domain.Treatment;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentDTO;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentToDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TreatmentService extends AbstractCrudService<Treatment, Long> {

    private final TreatmentRepository treatmentRepository;
    public TreatmentService(TreatmentRepository treatmentRepository) {
        super(treatmentRepository);
        this.treatmentRepository = treatmentRepository;
    }

    public Collection<TreatmentDTO> readAllByIdBeeColony(Long id) {
        ArrayList<Treatment> tmp = (ArrayList<Treatment>) treatmentRepository.findAllByColonyIdBeeColony(id);
        ArrayList<TreatmentDTO> res = new ArrayList<>();
        for (Treatment elem : tmp) {
            TreatmentDTO one = new TreatmentDTO();
            one.setIdColony(elem.getColony().getIdBeeColony());
            one.setIdType(elem.getTreatmentType().getID());
            one.setDateTime(elem.getDateTime());
            one.setId(elem.getID());
            res.add(one);
        }
        return res;
    }
}
