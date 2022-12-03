package cz.bee_kingdom.rest_api.dto.treatment;

import cz.bee_kingdom.domain.Treatment;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreatmentToDto implements Function<Treatment, TreatmentDTO> {
    @Override
    public TreatmentDTO apply(Treatment treatment) {
        TreatmentDTO ret = new TreatmentDTO();
        ret.setIdColony(treatment.getColony().getIdBeeColony());
        ret.setIdType(treatment.getTreatmentType().getIdTreatmentType());
        ret.setDateTime(treatment.getDateTime());
        return ret;
    }
}
