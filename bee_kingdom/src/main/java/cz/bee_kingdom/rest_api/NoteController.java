package cz.bee_kingdom.rest_api;

import cz.bee_kingdom.business.BeeColonyService;
import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.business.NoteService;
import cz.bee_kingdom.business.NoteTypeService;
import cz.bee_kingdom.domain.*;
import cz.bee_kingdom.rest_api.dto.note.NoteDTO;
import cz.bee_kingdom.rest_api.dto.note.NoteToDto;
import cz.bee_kingdom.rest_api.dto.note.NoteToEntity;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
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
    private final NoteTypeService noteTypeService;

    public NoteController(NoteTypeService noteTypeService, BeeColonyService beeColonyService, NoteService noteService, NoteToDto noteToDto, NoteToEntity noteToEntity) {
        this.beeColonyService = beeColonyService;
        this.noteService = noteService;
        this.noteToDto = noteToDto;
        this.noteToEntity = noteToEntity;
        this.noteTypeService = noteTypeService;
    }

    @PostMapping()
    public NoteDTO create(@RequestBody NoteDTO e, @PathVariable Long id_colony) {
        Optional<BeeColony> tmp = beeColonyService.readByID(id_colony);
        if(tmp.isEmpty()) {
            throw new EntityStateException("Invalid Bee Colony!");
        }

        Optional<TypeNote> type = noteTypeService.readByID(e.getTypeNote());
        if(type.isEmpty()) {
            throw new EntityStateException("Invalid note type!");
        }

        return noteToDto.apply(noteService.create(noteToEntity.apply(e).setColony(tmp.get()).setTypeNote(type.get())));
    }

    @GetMapping()
    public Collection<NoteDTO> readAll(@RequestParam(value="type", required = false)String typeRes) {
        System.out.println(typeRes);
        ArrayList<Note> tmp = new ArrayList<>();
        if(typeRes == null) {
            tmp = (ArrayList<Note>) noteService.readAll();
        } else {
            tmp = (ArrayList<Note>) noteService.filteredReadAll(typeRes);
        }
        ArrayList<NoteDTO> res = new ArrayList<NoteDTO>();

        for( var elem : tmp ) {
            res.add(noteToDto.apply(elem));
        }

        return res;
    }

    @GetMapping("/{id}")
    public NoteDTO readById(@PathVariable Long id) {
        Optional<Note> tmp = noteService.readByID(id);
        if(tmp.isEmpty()) {
            throw new EntityStateException("No treatment of this id: " + id);
        }
        return noteToDto.apply(tmp.get());
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

        Optional<TypeNote> type = noteTypeService.readByID(noteDTO.getTypeNote());
        if(type.isEmpty()) {
            throw new EntityStateException("Invalid Feeding type!");
        }

        tmp.get().setText(noteDTO.getText());
        tmp.get().setDateTime(noteDTO.getDate());
        tmp.get().setTypeNote(type.get());
        tmp.get().setColony(colony.get());

        noteService.update(tmp.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }
}
