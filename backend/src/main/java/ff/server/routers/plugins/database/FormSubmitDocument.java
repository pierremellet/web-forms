package ff.server.routers.plugins.database;

import ff.server.model.FormSubmit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formSubmits")
public class FormSubmitDocument extends FormSubmit {

    @Id
    public String id;

}
