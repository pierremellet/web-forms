package webforms.server.routers.plugins.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import webforms.server.model.FormSubmit;

@Document(collection = "formSubmits")
public class FormSubmitDocument extends FormSubmit {

    @Id
    public String id;

}
