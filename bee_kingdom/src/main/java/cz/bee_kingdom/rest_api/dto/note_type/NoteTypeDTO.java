package cz.bee_kingdom.rest_api.dto.note_type;

import lombok.Data;

@Data
public class NoteTypeDTO {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
