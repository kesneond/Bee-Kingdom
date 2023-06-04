package cz.bee_kingdom.rest_api.dto.treatment_type;

import cz.bee_kingdom.domain.TreatmentType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreatmentTypeToDto implements Function<TreatmentType, TreatmentTypeDTO> {
    @Override
    public TreatmentTypeDTO apply(TreatmentType treatmentType) {
        TreatmentTypeDTO tmp = new TreatmentTypeDTO();
        tmp.setName(treatmentType.getTreatmentTypeName());

        return tmp;
    }
}
