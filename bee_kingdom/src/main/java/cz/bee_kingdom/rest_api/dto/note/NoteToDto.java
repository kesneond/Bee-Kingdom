package cz.bee_kingdom.rest_api.dto.note;

import cz.bee_kingdom.domain.Note;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NoteToDto implements Function<Note, NoteDTO> {

    @Override
    public NoteDTO apply(Note note) {
        NoteDTO tmp = new NoteDTO();
        tmp.setDate(note.getDateTime());
        tmp.setText(note.getText());
        tmp.setTypeNote(note.getTypeNote());
        tmp.setIdColony(note.getColony().getIdBeeColony());

        return tmp;
    }
}
