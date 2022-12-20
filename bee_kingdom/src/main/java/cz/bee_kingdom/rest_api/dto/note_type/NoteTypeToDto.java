package cz.bee_kingdom.rest_api.dto.note_type;

import cz.bee_kingdom.domain.Note;
import cz.bee_kingdom.domain.TypeNote;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NoteTypeToDto implements Function<TypeNote, NoteTypeDTO> {
    @Override
    public NoteTypeDTO apply(TypeNote typeNote) {
        NoteTypeDTO tmp = new NoteTypeDTO();
        tmp.setName(typeNote.getID());
        return tmp;
    }
}
