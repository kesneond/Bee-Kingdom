package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.BeeColonyService;
import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.business.TreatmentService;
import cz.bee_kingdom.business.TreatmentTypeService;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.Treatment;
import cz.bee_kingdom.domain.TreatmentType;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentDTO;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentToDto;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentToEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/colonies/{id_colony}/treatment")
public class TreatmentController {

    private final BeeColonyService beeColonyService;
    private final TreatmentService treatmentService;
    private final TreatmentToDto treatmentToDto;
    private final TreatmentToEntity treatmentToEntity;
    private final TreatmentTypeService treatmentTypeService;

    public TreatmentController(TreatmentTypeService treatmentTypeService, BeeColonyService beeColonyService, TreatmentService treatmentService, TreatmentToDto treatmentToDto, TreatmentToEntity treatmentToEntity) {
        this.beeColonyService = beeColonyService;
        this.treatmentToDto = treatmentToDto;
        this.treatmentService = treatmentService;
        this.treatmentToEntity = treatmentToEntity;
        this.treatmentTypeService = treatmentTypeService;
    }

    @PostMapping
    public TreatmentDTO create(@RequestBody TreatmentDTO e, @PathVariable Long id_colony) {
        Optional<BeeColony> tmp = beeColonyService.readByID(id_colony);

        if(tmp.isEmpty()) {
            throw new EntityStateException("Invalid Bee colony!");
        }
        e.setIdColony(tmp.get().getIdBeeColony());

        Optional<TreatmentType> type = treatmentTypeService.readByID(e.getIdType());
        if(type.isEmpty()) {
            throw new EntityStateException("Invalid Treatment type!");
        }
        e.setIdType(type.get().getID());

        return treatmentToDto.apply(treatmentService.create(treatmentToEntity.apply(e).setColony(tmp.get()).setTreatmentType(type.get())));
    }

    @GetMapping
    public Collection<TreatmentDTO> readAllByIdBeeColony(@PathVariable Long id_colony) {
        return treatmentService.readAllByIdBeeColony(id_colony);
    }

    @GetMapping("/{id}")
    public TreatmentDTO readById(@PathVariable Long id) {
        Optional<Treatment> tmp = treatmentService.readByID(id);
        if(tmp.isEmpty()) {
            throw new EntityStateException("No treatment of this id: " + id);
        }
        return treatmentToDto.apply(tmp.get());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody TreatmentDTO e, @PathVariable Long id, @PathVariable Long id_colony) {
        Optional<Treatment> tmp = treatmentService.readByID(id);

        Optional<TreatmentType> tmpType = treatmentTypeService.readByID(e.getIdType());

        if(tmp.isPresent()) {
            if(tmpType.isEmpty()) {
                throw new EntityStateException("Invalid Treatment type!");
            }
            tmp.get().setTreatmentType(tmpType.get());
            tmp.get().setDateTime(e.getDateTime());
        }

        treatmentService.update(tmp.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        treatmentService.deleteById(id);
    }
}
