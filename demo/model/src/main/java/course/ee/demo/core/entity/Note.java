package course.ee.demo.core.entity;

import java.util.Objects;

public class Note {

    private Long id;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
