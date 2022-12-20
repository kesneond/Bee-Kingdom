package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.TypeNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTypeRepository extends JpaRepository<TypeNote, String>, CrudRepository<TypeNote, String> {
}
