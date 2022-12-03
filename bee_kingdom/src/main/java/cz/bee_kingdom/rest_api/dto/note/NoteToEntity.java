package cz.bee_kingdom.rest_api.dto.note;

import cz.bee_kingdom.domain.Note;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NoteToEntity implements Function<NoteDTO, Note> {

    @Override
    public Note apply(NoteDTO noteDTO) {
        return new Note(noteDTO.getTypeNote(), noteDTO.getText(), noteDTO.getDate());
    }
}
