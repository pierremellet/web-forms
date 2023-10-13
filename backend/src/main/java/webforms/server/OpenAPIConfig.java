package webforms.server;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webforms.server.model.FormFieldConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Configuration
public class OpenAPIConfig {

    private static final Logger LOG = LoggerFactory.getLogger(OpenAPIConfig.class);


    private Set<Class<? extends FormFieldConfig>> getFormFieldConfigs() {
        String packageToScan = "webforms.server.fields.plugins";
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages(packageToScan));
        return reflections.getSubTypesOf(FormFieldConfig.class);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        final OpenAPI openAPI = new OpenAPI();
        final Components components = new Components();
        final Map<String, Schema> schemas = new HashMap<>();
        components.setSchemas(schemas);

        this.getFormFieldConfigs().forEach(aClass -> {
            final Map<String, Schema> schema = ModelConverters.getInstance().read(aClass);
            components.getSchemas().putAll(schema);
            LOG.info("Create schema for class {}", aClass);
        });
        openAPI.setComponents(components);

        return openAPI;
    }

}
