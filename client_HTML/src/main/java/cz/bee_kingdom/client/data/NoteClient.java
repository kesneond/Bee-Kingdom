package cz.bee_kingdom.client.data;

import cz.bee_kingdom.client.model.FeedingDTO;
import cz.bee_kingdom.client.model.FeedingWebModel;
import cz.bee_kingdom.client.model.NoteDTO;
import cz.bee_kingdom.client.model.NoteWebModel;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class NoteClient {
    private static final String ONE_URI = "/{id}";
    private WebTarget allNoteEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleNoteEndpoint;


    public NoteClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allNoteEndpoint = c.target(url + "/colonies/{id_colony}/note");
        singleEndpointTemplate = allNoteEndpoint.path("/{id}");
    }

    public NoteDTO create(NoteDTO noteDTO) {
        return allNoteEndpoint
                .resolveTemplate("id_colony", noteDTO.getIdColony())
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(noteDTO, MediaType.APPLICATION_JSON_VALUE), NoteDTO.class);

    }

    public Collection<NoteWebModel> readAll(Long idColony) {
        var res = allNoteEndpoint
                .resolveTemplate("id_colony", idColony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(NoteWebModel[].class);
        return Arrays.asList(res);
    }

    public Collection<NoteWebModel> filteredReadAll(Long idColony, String type) {
        var res = allNoteEndpoint
                .resolveTemplate("id_colony", idColony)
                .queryParam("type", type)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(NoteWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(Long name) {
        singleNoteEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public NoteWebModel readById(Long name, Long id_colony) {
        setID(name);
        var res = singleNoteEndpoint
                .resolveTemplate("id_colony", id_colony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(NoteWebModel.class);
        } else if(res.getStatus() == 404) {
            return new NoteWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(NoteDTO noteDTO, Long id, Long id_colony) {
        setID(id);
        singleNoteEndpoint
                .resolveTemplate("id_colony", id_colony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(noteDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(Long name, Long id_colony) {
        setID(name);
        singleNoteEndpoint
                .resolveTemplate("id_colony", id_colony)
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }
}
