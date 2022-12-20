package cz.bee_kingdom;

import cz.bee_kingdom.business.BeeColonyService;
import cz.bee_kingdom.business.FeedingService;
import cz.bee_kingdom.business.FeedingTypeService;
import cz.bee_kingdom.dao.BeeColonyRepository;
import cz.bee_kingdom.dao.FeedingRepository;
import cz.bee_kingdom.domain.BeeColony;
import cz.bee_kingdom.domain.Feeding;
import cz.bee_kingdom.domain.FeedingType;
import cz.bee_kingdom.rest_api.FeedingController;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingDTO;
import cz.bee_kingdom.rest_api.dto.feeding.FeedingToDto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FeedingServiceTest {

    @Mock
    private FeedingRepository feedingRepository;

    @Autowired
    private FeedingService feedingService;

    @Test
    public void shouldAddFeeding() {
        Feeding toInsert = new Feeding();
        toInsert.setFeedingDate(Date.valueOf("2022-02-02"));
        toInsert.setFeedingType(new FeedingType("cukr"));

        Mockito.when(feedingRepository.existsById(toInsert.getID())).thenReturn(false);
        Mockito.when(feedingRepository.save(toInsert)).thenReturn(toInsert);

        Feeding res = feedingService.create(toInsert);

        assertEquals(res.getFeedingDate(), toInsert.getFeedingDate());
        assertEquals(res.getFeedingType(), toInsert.getFeedingType());
    }
}
