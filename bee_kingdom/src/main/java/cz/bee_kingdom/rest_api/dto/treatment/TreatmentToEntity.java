package cz.bee_kingdom.rest_api.dto.treatment;

import cz.bee_kingdom.domain.Treatment;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreatmentToEntity implements Function<TreatmentDTO, Treatment> {
    @Override
    public Treatment apply(TreatmentDTO treatmentDTO) {
        return new Treatment(treatmentDTO.getDateTime());
    }
}
