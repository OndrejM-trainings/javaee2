package course.ee.demo.ui.control;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import course.ee.demo.core.entity.Note;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import java.util.Collection;

@ApplicationScoped
public class RemoteNoteResource {

    public Collection<Note> getAll() {
        return ClientBuilder.newClient().target("http://localhost:8080/demo/rest/note")
                .request(APPLICATION_JSON)
                .get(new GenericType<Collection<Note>>() {
                });
    }
}
