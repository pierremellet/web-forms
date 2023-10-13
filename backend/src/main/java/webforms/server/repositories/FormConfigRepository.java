package webforms.server.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormConfigRepository extends MongoRepository<FormConfigDocument, String> {

    FormConfigDocument findByFormId(String formId);

}
