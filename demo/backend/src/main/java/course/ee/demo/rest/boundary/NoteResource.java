package course.ee.demo.rest.boundary;

import course.ee.demo.core.boundary.Repository;
import course.ee.demo.core.entity.Note;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

@Path("note")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

    @Inject
    Repository repository;

    @GET
    public Collection<Note> getAll(@QueryParam("limit") Integer maxResults) {
        if (maxResults != null) {
            return repository.getLimitedNotes(maxResults);
        } else {
            return repository.getAllNotes();
        }
    }

    @GET
    @Path("nodetails")
    public String getAllNoDetails(@QueryParam("limit") Integer maxResults) {
        Collection<Note> notes;
        if (maxResults != null) {
            notes = repository.getLimitedNotes(maxResults);
        } else {
            notes = repository.getAllNotes();
        }
        Jsonb noDetailsJsonb = JsonbBuilder.create(new JsonbConfig().withAdapters(new Note.NoDetailsAdapter()));
        return noDetailsJsonb.toJson(notes);
    }

    @POST
    public Note addNote(Note note) {
        return repository.addNote(note);
    }

    @PUT
    @Path("{id}")
    public Note updateNote(@PathParam("id") long id, Note note) {
        return repository.updateNote(id, note);
    }

    @DELETE
    @Path("{id}")
    public Note deleteNote(@PathParam("id") long id) {
        return repository.deleteNote(id);
    }

}
