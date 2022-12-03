package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.BeeColonyService;
import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.business.NoteService;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.Feeding;
import cz.bee_kingdom.domain.FeedingType;
import cz.bee_kingdom.domain.Note;
import cz.bee_kingdom.rest_api.dto.note.NoteDTO;
import cz.bee_kingdom.rest_api.dto.note.NoteToDto;
import cz.bee_kingdom.rest_api.dto.note.NoteToEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/colonies/{id_colony}/note")
public class NoteController {
    private final BeeColonyService beeColonyService;
    private final NoteService noteService;
    private final NoteToDto noteToDto;
    private final NoteToEntity noteToEntity;

    public NoteController(BeeColonyService beeColonyService, NoteService noteService, NoteToDto noteToDto, NoteToEntity noteToEntity) {
        this.beeColonyService = beeColonyService;
        this.noteService = noteService;
        this.noteToDto = noteToDto;
        this.noteToEntity = noteToEntity;
    }

    @PostMapping()
    public NoteDTO create(@RequestBody NoteDTO e, @PathVariable Long id_colony) {
        Optional<BeeColony> tmp = beeColonyService.readByID(id_colony);
        if(tmp.isEmpty()) {
            throw new EntityStateException("Invalid Bee Colony!");
        }

        return noteToDto.apply(noteService.create(noteToEntity.apply(e).setColony(tmp.get())));
    }

    @GetMapping()
    public Collection<NoteDTO> readAll() {
        ArrayList<Note> tmp = (ArrayList<Note>) noteService.readAll();
        ArrayList<NoteDTO> res = new ArrayList<NoteDTO>();

        for( var elem : tmp ) {
            res.add(noteToDto.apply(elem));
        }

        return res;
    }

    @PutMapping("/{id}")
    public void update(@RequestBody NoteDTO noteDTO, @PathVariable Long id, @PathVariable Long id_colony) {
        Optional<Note> tmp = noteService.readByID(id);
        if(tmp.isEmpty()) {
            throw new EntityStateException("Invalid id to update!");
        }

        Optional<BeeColony> colony = beeColonyService.readByID(id_colony);
        if(colony.isEmpty()) {
            throw new EntityStateException("Invalid Bee Colony!");
        }

        tmp.get().setText(noteDTO.getText());
        tmp.get().setDateTime(noteDTO.getDate());
        tmp.get().setTypeNote(noteDTO.getTypeNote());
        tmp.get().setColony(colony.get());

        noteService.update(tmp.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }
}
