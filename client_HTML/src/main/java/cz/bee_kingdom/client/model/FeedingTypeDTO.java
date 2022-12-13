package cz.bee_kingdom.client.model;

public class FeedingTypeDTO {
    public String name;

    public FeedingTypeDTO(String name) {
        this.name = name;
    }

    public FeedingTypeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
