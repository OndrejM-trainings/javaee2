package course.ee.demo.ui.control;

import course.ee.demo.core.entity.Note;
import jakarta.enterprise.context.RequestScoped;
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
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface NoteResource {

    @GET
    Collection<Note> getAll();

    @GET
    Collection<Note> getAll(@QueryParam("limit") Integer maxResults);

    @GET
    @Path("nodetails")
    Collection<Note> getAllNoDetails(@QueryParam("limit") Integer maxResults);

    @POST
    Note addNote(Note note);

    @PUT
    @Path("{id}")
    Note updateNote(@PathParam("id") long id, Note note);

    @DELETE
    @Path("{id}")
    Note deleteNote(@PathParam("id") long id);

}
