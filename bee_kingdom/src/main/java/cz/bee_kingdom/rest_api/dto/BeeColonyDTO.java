package cz.bee_kingdom.rest_api.dto;

import lombok.Data;

@Data
public class BeeColonyDTO {
    public Long extensionsNumber;
    public Long availability;
    public Long name;

    public Long getExtensionsNumber() {
        return extensionsNumber;
    }

    public void setExtensionsNumber(Long extensioinsNumber) {
        this.extensionsNumber = extensioinsNumber;
    }

    public Long getAvailability() {
        return availability;
    }

    public void setAvailability(Long availability) {
        this.availability = availability;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }
}
