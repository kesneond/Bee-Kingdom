package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.BeeColony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeeColonyRepository extends JpaRepository<BeeColony, Long>, CrudRepository<BeeColony, Long> {

}
