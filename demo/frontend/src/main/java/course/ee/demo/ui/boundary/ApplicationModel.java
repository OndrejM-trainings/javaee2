package course.ee.demo.ui.boundary;

import course.ee.demo.core.entity.Note;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.Collection;
import java.util.Collections;

@Named("model")
@RequestScoped
public class ApplicationModel {
    public Collection<Note> getNotes() {
        return Collections.emptyList();
    }
}
