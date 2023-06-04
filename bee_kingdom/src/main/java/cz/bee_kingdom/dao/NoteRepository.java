package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.Note;
import cz.bee_kingdom.domain.TypeNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>, CrudRepository<Note, Long> {

    public Collection<Note> findAllByColonyIdBeeColony(Long colony_idBeeColony);

    public Collection<Note> findAllByTypeNoteIsAndColonyIdBeeColony(TypeNote typeNote, Long colony_idBeeColony);
}
