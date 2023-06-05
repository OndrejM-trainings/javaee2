package course.ee.demo.ui.boundary;

import course.ee.demo.core.entity.Note;
import course.ee.demo.ui.control.RemoteNoteResource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Collection;

@Named("model")
@RequestScoped
public class ApplicationModel {

    private Collection<Note> notes;

    @Inject
    RemoteNoteResource noteResource;

    public Collection<Note> getNotes() {
        if (notes == null) {
            notes = noteResource.getAll();
        }
        return notes;
    }
}
