package cz.bee_kingdom.rest_api.dto.feeding_type;

import lombok.Data;

@Data
public class FeedingTypeDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
