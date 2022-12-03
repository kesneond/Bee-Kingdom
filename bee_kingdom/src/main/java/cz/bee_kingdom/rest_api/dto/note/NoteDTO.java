package cz.bee_kingdom.rest_api.dto.note;

import cz.bee_kingdom.domain.TypeNote;
import lombok.Data;

import java.sql.Date;

@Data
public class NoteDTO {
    private String text;
    private Date date;
    private TypeNote typeNote;
    private Long idColony;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeNote getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(TypeNote typeNote) {
        this.typeNote = typeNote;
    }

    public Long getIdColony() {
        return idColony;
    }

    public void setIdColony(Long idColony) {
        this.idColony = idColony;
    }
}
