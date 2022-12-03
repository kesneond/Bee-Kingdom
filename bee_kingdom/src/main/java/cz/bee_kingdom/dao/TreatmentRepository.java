package cz.bee_kingdom.dao;

import cz.bee_kingdom.domain.Treatment;
import cz.bee_kingdom.rest_api.dto.treatment.TreatmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long>, CrudRepository<Treatment, Long> {

    Collection<Treatment> findAllByColonyIdBeeColony(Long id);
}
