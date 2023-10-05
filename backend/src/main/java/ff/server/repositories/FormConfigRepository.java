package ff.server.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormConfigRepository extends MongoRepository<FormConfigDocument, String> {

    public FormConfigDocument findByFormId(String formId);

}
