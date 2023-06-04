package cz.bee_kingdom.client.model;

public class NoteTypeDTO {
    public String name;

    public NoteTypeDTO(String name) {
        this.name = name;
    }

    public NoteTypeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
