package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.FeedingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingTypeRepository extends JpaRepository<FeedingType, Long> {
}
