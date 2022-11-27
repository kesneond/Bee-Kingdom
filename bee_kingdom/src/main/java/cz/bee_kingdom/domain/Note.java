package cz.bee_kingdom.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Note implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long idNote;

    @Column(unique = true)
    private TypeNote typeNote;

    private String text;
    private LocalDateTime dateTime;

    @ManyToOne
    BeeColony colony;

    @Override
    public Long getID() {
        return idNote;
    }
}
