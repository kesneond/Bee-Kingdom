package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.Feeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FeedingRepository extends JpaRepository<Feeding, Long>, CrudRepository<Feeding, Long> {

    public ArrayList<Feeding> findAllByBeeColonyIdBeeColony(Long id);
}
