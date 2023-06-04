package cz.bee_kingdom.rest_api.dto.note;

import lombok.Data;

import java.sql.Date;

@Data
public class NoteDTO {
    private Long id;
    private String text;
    private Date date;
    private String typeNote;
    private Long idColony;
}
