package cz.bee_kingdom.client.data;

import cz.bee_kingdom.client.model.FeedingTypeDTO;
import cz.bee_kingdom.client.model.FeedingTypeWebModel;
import cz.bee_kingdom.client.model.TreatmentTypeDTO;
import cz.bee_kingdom.client.model.TreatmentTypeWebModel;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class FeedingTypeClient {
    private static final String ONE_URI = "/{id}";
    private WebTarget allFeedingTypeEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleFeedingTypeEndpoint;


    public FeedingTypeClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allFeedingTypeEndpoint = c.target(url + "/feeding_type");
        singleEndpointTemplate = allFeedingTypeEndpoint.path("/{id}");
    }

    public FeedingTypeDTO create(FeedingTypeDTO feedingTypeDTO) {
        return allFeedingTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(feedingTypeDTO, MediaType.APPLICATION_JSON_VALUE), FeedingTypeDTO.class);

    }

    public Collection<FeedingTypeWebModel> readAll() {
        var res = allFeedingTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(FeedingTypeWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(String name) {
        singleFeedingTypeEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public FeedingTypeWebModel readById(String name) {
        setID(name);
        var res = singleFeedingTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(FeedingTypeWebModel.class);
        } else if(res.getStatus() == 404) {
            return new FeedingTypeWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(FeedingTypeDTO feedingTypeDTO, String id) {
        setID(id);
        singleFeedingTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(feedingTypeDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(String name) {
        setID(name);
        singleFeedingTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }
}
