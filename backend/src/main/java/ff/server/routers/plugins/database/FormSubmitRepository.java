package ff.server.routers.plugins.database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormSubmitRepository extends MongoRepository<FormSubmitDocument, String> {

}
