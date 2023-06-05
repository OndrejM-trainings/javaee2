package course.ee.demo.soap.boundary;

import course.ee.demo.core.boundary.Repository;
import course.ee.demo.core.entity.Note;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.Collection;

@WebService
@Stateless
public class NoteService {
    @Inject
    Repository repository;

    @WebMethod
    public Collection<Note> getAll() {
        return repository.getAllNotes();
    }

}
