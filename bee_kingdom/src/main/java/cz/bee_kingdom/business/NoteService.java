package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.NoteRepository;
import cz.bee_kingdom.domain.Note;
import cz.bee_kingdom.domain.TypeNote;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NoteService extends AbstractCrudService<Note, Long> {

    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        super(noteRepository);
        this.noteRepository = noteRepository;
    }

    public Collection<Note> filteredReadAll(String type){
        TypeNote tmp = new TypeNote(type);
        return noteRepository.findAllByTypeNoteIs(tmp);
    }
}
