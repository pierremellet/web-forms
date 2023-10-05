package ff.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springdoc.core.OpenAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

 import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;

@SpringBootApplication
public class App {

    @Autowired
    private Environment environment;
    @Autowired
    private ApplicationContext applicationContext;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper;
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
    @Bean
    public ScriptEngine javascriptEngine() {
        final ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByName("js");
    }



}