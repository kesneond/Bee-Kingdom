package cz.bee_kingdom.rest_api.dto.note_type;

import cz.bee_kingdom.domain.TypeNote;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NoteTypeToEntity implements Function<NoteTypeDTO, TypeNote> {
    @Override
    public TypeNote apply(NoteTypeDTO noteTypeDTO) {
        return new TypeNote(noteTypeDTO.getName());
    }
}
