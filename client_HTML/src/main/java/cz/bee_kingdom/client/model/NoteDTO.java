package cz.bee_kingdom.client.model;

import java.sql.Date;

public class NoteDTO {
    public Long id;
    public String text;
    public Date date;
    public String typeNote;
    public Long idColony;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NoteDTO(Long id, String text, Date date, String type, Long idColony) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.typeNote = type;
        this.idColony = idColony;
    }

    public NoteDTO() {
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

    public void setTypeNote(String type) {
        this.typeNote = type;
    }

    public Long getIdColony() {
        return idColony;
    }

    public void setIdColony(Long idColony) {
        this.idColony = idColony;
    }
}
