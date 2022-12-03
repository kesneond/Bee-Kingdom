package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.NoteRepository;
import cz.bee_kingdom.domain.Note;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends AbstractCrudService<Note, Long> {

    public NoteService(NoteRepository noteRepository) {
        super(noteRepository);
    }
}
