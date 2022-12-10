package cz.bee_kingdom.client.data;

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
public class TreatmentClient {
    private static final String ONE_URI = "/{id}";
    private WebTarget allTreatmentEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleTreatmentEndpoint;


    public TreatmentClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allTreatmentEndpoint = c.target(url + "/colonies/{id_colony}/treatment");
        singleEndpointTemplate = allTreatmentEndpoint.path("/{id}");
    }

    public TreatmentDTO create(TreatmentDTO treatmentDTO) {
        return allTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(treatmentDTO, MediaType.APPLICATION_JSON_VALUE), TreatmentDTO.class);

    }

    public Collection<TreatmentWebModel> readAll(Long idColony) {
        var res = allTreatmentEndpoint
                .resolveTemplate("id_colony", idColony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(TreatmentWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(Long name) {
        singleTreatmentEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public TreatmentWebModel readById(Long name) {
        setID(name);
        var res = singleTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(TreatmentWebModel.class);
        } else if(res.getStatus() == 404) {
            return new TreatmentWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(TreatmentDTO treatmentDTO, Long id) {
        setID(id);
        singleTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(treatmentDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(Long name) {
        setID(name);
        singleEndpointTemplate
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }

}
