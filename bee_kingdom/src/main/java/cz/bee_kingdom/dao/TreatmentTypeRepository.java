package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.TreatmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentTypeRepository extends JpaRepository<TreatmentType, Long>, CrudRepository<TreatmentType, Long> {
}
