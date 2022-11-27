package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.Feeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingRepository extends JpaRepository<Feeding, Long> {
}
