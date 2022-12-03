package cz.bee_kingdom.domain;

import cz.bee_kingdom.rest_api.dto.note.NoteDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Note implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idNote;

    private TypeNote typeNote;

    private String text;
    private Date dateTime;

    @ManyToOne
    BeeColony colony;

    public Note(TypeNote typeNote, String text, Date dateTime) {
        this.typeNote = typeNote;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Note() {}

    public TypeNote getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(TypeNote typeNote) {
        this.typeNote = typeNote;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BeeColony getColony() {
        return colony;
    }

    public Note setColony(BeeColony colony) {
        this.colony = colony;
        return this;
    }

    @Override
    public Long getID() {
        return idNote;
    }
}
