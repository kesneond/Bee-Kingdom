package cz.bee_kingdom.rest_api.dto.note;

import cz.bee_kingdom.domain.TypeNote;
import lombok.Data;

import java.sql.Date;

@Data
public class NoteDTO {
    private Long id;
    private String text;
    private Date date;
    private String typeNote;
    private Long idColony;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    public Long getIdColony() {
        return idColony;
    }

    public void setIdColony(Long idColony) {
        this.idColony = idColony;
    }
}
