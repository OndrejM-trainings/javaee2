package course.ee.demo.rest.control;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyOrderStrategy;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JSONConfigurator implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class<?> type) {
        JsonbConfig config = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL);
        return JsonbBuilder.create(config);
    }
}
