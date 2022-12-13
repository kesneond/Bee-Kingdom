package cz.bee_kingdom.client.data;

import cz.bee_kingdom.client.model.FeedingDTO;
import cz.bee_kingdom.client.model.FeedingWebModel;
import cz.bee_kingdom.client.model.TreatmentDTO;
import cz.bee_kingdom.client.model.TreatmentWebModel;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class FeedingClient {
    private static final String ONE_URI = "/{id}";
    private WebTarget allFeedingEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleFeedingEndpoint;


    public FeedingClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allFeedingEndpoint = c.target(url + "/colonies/{id_colony}/feeding");
        singleEndpointTemplate = allFeedingEndpoint.path("/{id}");
    }

    public FeedingDTO create(FeedingDTO feedingDTO) {
        return allFeedingEndpoint
                .resolveTemplate("id_colony", feedingDTO.getIdColony())
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(feedingDTO, MediaType.APPLICATION_JSON_VALUE), FeedingDTO.class);

    }

    public Collection<FeedingWebModel> readAll(Long idColony) {
        var res = allFeedingEndpoint
                .resolveTemplate("id_colony", idColony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(FeedingWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(Long name) {
        singleFeedingEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public FeedingWebModel readById(Long name, Long id_colony) {
        setID(name);
        var res = singleFeedingEndpoint
                .resolveTemplate("id_colony", id_colony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(FeedingWebModel.class);
        } else if(res.getStatus() == 404) {
            return new FeedingWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(FeedingDTO feedingDTO, Long id, Long id_colony) {
        setID(id);
        singleFeedingEndpoint
                .resolveTemplate("id_colony", id_colony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(feedingDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(Long name) {
        setID(name);
        singleEndpointTemplate
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }
}
