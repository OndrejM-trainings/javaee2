package course.ee.demo.core.boundary;

import course.ee.demo.core.entity.Note;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class Repository {

    private Map<Long, Note> notes = new HashMap<>();
    private long nextId = 1;

    public Collection<Note> getAllNotes() {
        return notes.values();
    }

    public Note addNote(Note note) {
        if (note.getId() == null) {
            note.setId(nextId++);
        }
        notes.put(note.getId(), note);
        return note;
    }

    public Note updateNote(long id, Note note) {
        if (notes.containsKey(id)) {
            note.setId(id);
            return addNote(note);
        } else {
            throw new IllegalArgumentException("Note with id=" + id + " doesn't exist, cannot update it");
        }
    }

    public Note deleteNote(long id) {
        if (notes.containsKey(id)) {
            return notes.remove(id);
        } else {
            throw new IllegalArgumentException("Note with id=" + id + " doesn't exist, cannot delete it");
        }
    }
}
