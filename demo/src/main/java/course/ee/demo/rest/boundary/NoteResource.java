package course.ee.demo.rest.boundary;

import course.ee.demo.core.boundary.Repository;
import course.ee.demo.core.entity.Note;
import course.ee.demo.rest.control.ErrorResponse;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

@Path("note")
@RequestScoped
public class NoteResource {

    @Inject
    Repository repository;

    @GET
    public Collection<Note> getAll() {
        return repository.getAllNotes();
    }

    @POST
    public Note addNote(Note note) {
        return repository.addNote(note);
    }

    @PUT
    @Path("{id}")
    public Note updateNote(@PathParam("id") long id, Note note) {
        try {
            return repository.updateNote(id, note);
        } catch (IllegalArgumentException e) {
            throw badRequest(e);
        }
    }

    private BadRequestException badRequest(Exception e) throws BadRequestException {
        return new BadRequestException(Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(e.getMessage()))
                .build());
    }

    @DELETE
    @Path("{id}")
    public Note deleteNote(@PathParam("id") long id) {
        try {
            return repository.deleteNote(id);
        } catch (IllegalArgumentException e) {
            throw badRequest(e);
        }
    }

}
