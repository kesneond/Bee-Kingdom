package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>, CrudRepository<Note, Long> {
}
