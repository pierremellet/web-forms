package webforms.server.repositories;

import webforms.server.model.FormConfig;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forms")
public class FormConfigDocument extends FormConfig {

    @Id
    public String id;

}
