package cz.bee_kingdom.client.data;

import cz.bee_kingdom.client.model.ColonyDTO;
import cz.bee_kingdom.client.model.ColonyWebModel;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collection;

@Component
public class BeeColonyClient {
    private static final String ONE_URI = "/{id}";
    private final WebClient colonyWebClient;
    private WebTarget allColoniesEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleColonyEndpoint;


    public BeeColonyClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allColoniesEndpoint = c.target(url + "/colonies");
        singleEndpointTemplate = allColoniesEndpoint.path("/{id}");
        colonyWebClient = WebClient.create(url+"/colonies");
        System.out.println(colonyWebClient.get().retrieve().bodyToFlux(ColonyDTO.class).collectList().block());
    }

    public ColonyDTO create(ColonyDTO colonyDTO) {
        return allColoniesEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(colonyDTO, MediaType.APPLICATION_JSON_VALUE), ColonyDTO.class);

    }

    public Collection<ColonyWebModel> readAll() {
        var res = allColoniesEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(ColonyWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(Long name) {
        singleColonyEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public ColonyWebModel readById(Long name) {
        setID(name);
        var res = singleColonyEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(ColonyWebModel.class);
        } else if(res.getStatus() == 404) {
            return new ColonyWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(ColonyDTO colonyDTO) {
        setID(colonyDTO.getName());
        singleColonyEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(colonyDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(Long name) {
        setID(name);
        singleEndpointTemplate
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }

}
