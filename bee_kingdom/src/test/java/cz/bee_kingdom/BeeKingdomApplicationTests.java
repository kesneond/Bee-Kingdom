package cz.bee_kingdom;

import cz.bee_kingdom.business.BeeColonyService;
import cz.bee_kingdom.business.EntityStateException;
import cz.bee_kingdom.business.FeedingService;
import cz.bee_kingdom.business.FeedingTypeService;
import cz.bee_kingdom.dao.BeeColonyRepository;
import cz.bee_kingdom.dao.FeedingRepository;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.Feeding;
import cz.bee_kingdom.domain.FeedingType;
import cz.bee_kingdom.rest_api.FeedingController;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyDTO;
import cz.bee_kingdom.rest_api.dto.bee_colony.BeeColonyToEntity;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityManagerFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class BeeKingdomApplicationTests {

	@Autowired
	BeeColonyService beeColonyService;

	@MockBean
	FeedingTypeService feedingTypeService;

	@Autowired
	FeedingController feedingController;

	@Autowired
	BeeColonyRepository repo;

	@MockBean
	FeedingRepository feedingRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	void shouldReturnException() {

		BeeColony toInsert = new BeeColony();

		assertThrows(
				EntityStateException.class,
				() -> beeColonyService.create(toInsert)
		);
	}

	@Test
	void shouldCreateColony() {
		int size = ((Collection<BeeColony>)beeColonyService.readAll()).size();

		Collection<BeeColony> tmp = (Collection<BeeColony>) beeColonyService.readAll();
		assertEquals(size, tmp.size());
		BeeColony inserted = beeColonyService.create(new BeeColony(32L, 21L, 2L, 32L));
		System.out.println(inserted);
		tmp = (Collection<BeeColony>) beeColonyService.readAll();
		assertEquals(size+1, tmp.size());
		beeColonyService.deleteById(32L);
		tmp = (Collection<BeeColony>) beeColonyService.readAll();
		assertEquals(size, tmp.size());
	}
}
