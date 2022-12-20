package cz.bee_kingdom.client.model;

public class TreatmentTypeDTO {
    public String name;

    TreatmentTypeDTO(String name){
        this.name = name;
    }

    public TreatmentTypeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
