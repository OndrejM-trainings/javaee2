package course.ee.demo.ui.control;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import course.ee.demo.core.entity.Note;
import course.ee.demo.core.entity.User;
import course.ee.demo.soap.boundary.NoteService;
import course.ee.demo.soap.boundary.NoteServiceService;
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
        return getAllEE();
//        return getAllMP();
//        return getAllSOAP();
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

    private Collection<Note> getAllSOAP() {
        NoteServiceService service = new NoteServiceService();
        NoteService port = service.getNoteServicePort();
        return port.getAll().stream().map(soapNote -> {
            User user = new User();
            user.setFirstName(soapNote.getAuthor().getFirstName());
            user.setLastName(soapNote.getAuthor().getLastName());
            user.setUserName(soapNote.getAuthor().getUserName());
            user.setId(soapNote.getAuthor().getId());

            Note note = new Note();
            note.setId(soapNote.getId());
            note.setAuthor(user);
            note.setDescription(soapNote.getDescription());
            note.setTitle(soapNote.getTitle());

            return note;
        }).toList();
    }

}
