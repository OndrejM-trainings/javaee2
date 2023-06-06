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

        // Configures JSON-B mapper to order properties in the JSON alphabetically, from A to Z
        JsonbConfig config = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL);

        /* Uses injected context ResourceInfo to check whether
           the resource method to be executed is on the NoteResource class and has @Path("nodetails") annotation.
           Only for that method it will use an adapter, which filters only the main info
           from the Note object.
         */
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
