package cz.bee_kingdom.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TypeNote implements Serializable, DomainEntity<String> {
    @Id
    private String typeNoteName;

    public TypeNote(String name) {
        this.typeNoteName = name;
    }

    public TypeNote() {
    }

    public String getTypeNoteName() {
        return typeNoteName;
    }

    public void setTypeNoteName(String typeNoteName) {
        this.typeNoteName = typeNoteName;
    }

    @Override
    public String getID() {
        return typeNoteName;
    }
}
