package course.ee.demo.rest.control;

import course.ee.demo.core.entity.Note;
import course.ee.demo.rest.boundary.NoteResource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyOrderStrategy;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JSONConfigurator implements ContextResolver<Jsonb> {
    @Context
    private ResourceInfo ri;
    @Override
    public Jsonb getContext(Class<?> type) {
        JsonbConfig config = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL);
        if (NoteResource.class.isAssignableFrom(ri.getResourceClass())
                && ri.getResourceMethod().isAnnotationPresent(Path.class)) {
            String path = ri.getResourceMethod().getAnnotation(Path.class).value();
            if ("nodetails".equals(path)) {
                config.withAdapters(new Note.NoDetailsAdapter());
            }
        }
        return JsonbBuilder.create(config);
    }
}
