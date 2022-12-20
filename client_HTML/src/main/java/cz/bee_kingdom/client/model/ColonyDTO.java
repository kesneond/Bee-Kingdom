package cz.bee_kingdom.client.model;

public class ColonyDTO {
    public Long extensionsNumber;
    public Long availability;
    public Long name;

    public ColonyDTO() {
    }

    public ColonyDTO(Long extensionsNumber, Long availability, Long name) {
        this.extensionsNumber = extensionsNumber;
        this.availability = availability;
        this.name = name;
    }

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
