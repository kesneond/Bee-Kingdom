package cz.bee_kingdom.business;

import cz.bee_kingdom.dao.NoteTypeRepository;
import cz.bee_kingdom.domain.TypeNote;
import org.springframework.stereotype.Service;

@Service
public class NoteTypeService extends AbstractCrudService<TypeNote, String>{

    public NoteTypeService(NoteTypeRepository noteTypeRepository) { super(noteTypeRepository); }
}
