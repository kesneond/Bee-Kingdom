package cz.bee_kingdom.client.data;

import cz.bee_kingdom.client.model.FeedingTypeDTO;
import cz.bee_kingdom.client.model.FeedingTypeWebModel;
import cz.bee_kingdom.client.model.NoteTypeDTO;
import cz.bee_kingdom.client.model.NoteTypeWebModel;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class NoteTypeClient {
    private static final String ONE_URI = "/{id}";
    private WebTarget allNoteTypeEndpoint;
    private WebTarget singleEndpointTemplate;
    private WebTarget singleNoteTypeEndpoint;


    public NoteTypeClient(@Value("${backend_url}") String url) {
        var c = ClientBuilder.newClient();
        allNoteTypeEndpoint = c.target(url + "/note_type");
        singleEndpointTemplate = allNoteTypeEndpoint.path("/{id}");
    }

    public NoteTypeDTO create(NoteTypeDTO noteTypeDTO) {
        return allNoteTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .post(Entity.entity(noteTypeDTO, MediaType.APPLICATION_JSON_VALUE), NoteTypeDTO.class);

    }

    public Collection<NoteTypeWebModel> readAll() {
        var res = allNoteTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get(NoteTypeWebModel[].class);
        return Arrays.asList(res);
    }

    public void setID(String name) {
        singleNoteTypeEndpoint = singleEndpointTemplate.resolveTemplate("id", name);
    }

    public NoteTypeWebModel readById(String name) {
        setID(name);
        var res = singleNoteTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .get();
        if(res.getStatus() == 200 ) {
            return res.readEntity(NoteTypeWebModel.class);
        } else if(res.getStatus() == 404) {
            return new NoteTypeWebModel();
        } else {
            throw new RuntimeException(res.getStatusInfo().getReasonPhrase());
        }
    }

    public void update(NoteTypeDTO noteTypeDTO, String id) {
        setID(id);
        singleNoteTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .put(Entity.entity(noteTypeDTO, MediaType.APPLICATION_JSON_VALUE));
    }

    public void delete(String name) {
        setID(name);
        singleNoteTypeEndpoint
                .request(MediaType.APPLICATION_JSON_VALUE)
                .delete();
    }
}
