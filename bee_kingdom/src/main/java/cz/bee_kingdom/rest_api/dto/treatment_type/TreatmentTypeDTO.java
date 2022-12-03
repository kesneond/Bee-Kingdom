package cz.bee_kingdom.rest_api.dto.treatment_type;

import lombok.Data;

@Data
public class TreatmentTypeDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
