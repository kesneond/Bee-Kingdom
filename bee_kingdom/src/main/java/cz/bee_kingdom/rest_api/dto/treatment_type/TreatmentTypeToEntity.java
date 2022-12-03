package cz.bee_kingdom.rest_api.dto.treatment_type;

import cz.bee_kingdom.domain.TreatmentType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreatmentTypeToEntity implements Function<TreatmentTypeDTO, TreatmentType> {
    @Override
    public TreatmentType apply(TreatmentTypeDTO treatmentTypeDTO) {
        return new TreatmentType(treatmentTypeDTO.getName());
    }
}
