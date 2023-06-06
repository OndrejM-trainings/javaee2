package course.ee.demo.core.entity;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Note {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private User author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        return id != null ? id.intValue() : -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (this.id != null && this.id.equals(other.id)) {
            return true;
        }
        if (this.id == null && other.id == null) {
            if (!Objects.equals(this.title, other.title)) {
                return false;
            }
            return Objects.equals(this.description, other.description);
        } else {
            return false;
        }
    }

    public static class NoDetailsAdapter implements JsonbAdapter<Note, JsonObject> {

        @Override
        public JsonObject adaptToJson(Note note) throws Exception {
            return Json.createObjectBuilder()
                    .add("id", note.getId())
                    .add("title", note.getTitle())
                    .add("status", note.getStatus().name())
                    .build();
        }

        @Override
        public Note adaptFromJson(JsonObject obj) throws Exception {
            throw new UnsupportedOperationException("Not supported.");
        }

    }
}
