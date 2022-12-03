package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.TreatmentTypeService;
import cz.bee_kingdom.dao.TreatmentTypeRepository;
import cz.bee_kingdom.domain.TreatmentType;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentToDto;
import cz.bee_kingdom.rest_api.dto.treatment_type.TreatmentTypeDTO;
import cz.bee_kingdom.rest_api.dto.treatment_type.TreatmentTypeToDto;
import cz.bee_kingdom.rest_api.dto.treatment_type.TreatmentTypeToEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treatment_type")
public class TreatmentTypeController extends AbstractCrudController<TreatmentType, TreatmentTypeDTO, String> {

    public TreatmentTypeController(TreatmentTypeService treatmentTypeService, TreatmentTypeToDto treatmentToDto, TreatmentTypeToEntity treatmentTypeToEntity) {
        super(treatmentTypeService, treatmentToDto, treatmentTypeToEntity);
    }

    @PutMapping("/{id}")
    @Override
    public void update(@RequestBody TreatmentTypeDTO e, @PathVariable String id) {
        this.delete(id);
        this.create(e);
    }
}
