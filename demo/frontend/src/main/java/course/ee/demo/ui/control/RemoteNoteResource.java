package course.ee.demo.ui.control;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import course.ee.demo.core.entity.Note;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class RemoteNoteResource {

    public Collection<Note> getAll() {
        return getAllMP();
    }

    private Collection<Note> getAllMP() {
        return getNoteResource().getAll();
    }

    private NoteResource getNoteResource() {
        try {
            return RestClientBuilder.newBuilder()
                    .baseUri(new URI("http://localhost:8080/demo/rest"))
                    .build(NoteResource.class);
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Collection<Note> getAllEE() {
        return ClientBuilder.newClient().target("http://localhost:8080/demo/rest/note")
                .request(APPLICATION_JSON)
                .get(new GenericType<Collection<Note>>() {
                });
    }
}
