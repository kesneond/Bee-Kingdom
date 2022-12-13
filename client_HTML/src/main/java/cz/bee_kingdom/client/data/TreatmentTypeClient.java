package cz.bee_kingdom.client.data;

import cz.bee_kingdom.client.model.TreatmentDTO;
import cz.bee_kingdom.client.model.TreatmentTypeDTO;
import cz.bee_kingdom.client.model.TreatmentTypeWebModel;
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
public class TreatmentTypeClient {
    private static final String ONE_URI = "/{id}";
    private WebTarget allTreatmentEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleTreatmentEndpoint;


    public TreatmentTypeClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allTreatmentEndpoint = c.target(url + "/treatment_type");
        singleEndpointTemplate = allTreatmentEndpoint.path("/{id}");
    }

    public TreatmentTypeDTO create(TreatmentTypeDTO treatmentDTO) {
        return allTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(treatmentDTO, MediaType.APPLICATION_JSON_VALUE), TreatmentTypeDTO.class);

    }

    public Collection<TreatmentTypeWebModel> readAll() {
        var res = allTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(TreatmentTypeWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(String name) {
        singleTreatmentEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public TreatmentTypeWebModel readById(String name) {
        setID(name);
        var res = singleTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(TreatmentTypeWebModel.class);
        } else if(res.getStatus() == 404) {
            return new TreatmentTypeWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(TreatmentTypeDTO treatmentDTO, String id) {
        setID(id);
        singleTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(treatmentDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(String name) {
        setID(name);
        singleTreatmentEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }
}
