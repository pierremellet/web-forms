package webforms.server.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import webforms.server.model.FormConfig;

@Document(collection = "forms")
public class FormConfigDocument extends FormConfig {

    @Id
    public String id;

}
