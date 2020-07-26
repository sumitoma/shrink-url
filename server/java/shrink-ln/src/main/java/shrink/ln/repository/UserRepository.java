package shrink.ln.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import shrink.ln.repository.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
