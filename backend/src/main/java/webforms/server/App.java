package webforms.server;

 import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
 import webforms.server.model.FormConfig;


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

        final ObjectMapper om = new ObjectMapper();
                om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return om;
    }





}