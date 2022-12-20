package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.NoteTypeService;
import cz.bee_kingdom.domain.TypeNote;
import cz.bee_kingdom.rest_api.dto.feeding_type.FeedingTypeDTO;
import cz.bee_kingdom.rest_api.dto.note_type.NoteTypeDTO;
import cz.bee_kingdom.rest_api.dto.note_type.NoteTypeToDto;
import cz.bee_kingdom.rest_api.dto.note_type.NoteTypeToEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note_type")
public class NoteTypeController extends AbstractCrudController<TypeNote, NoteTypeDTO, String> {
    public NoteTypeController(NoteTypeService noteTypeService, NoteTypeToDto noteTypeToDto, NoteTypeToEntity noteTypeToEntity) {
        super(noteTypeService, noteTypeToDto, noteTypeToEntity);
    }

    @PutMapping("/{id}")
    @Override
    public void update(@RequestBody NoteTypeDTO e, @PathVariable String id) {
        super.delete(id);
        super.create(e);
    }
}
