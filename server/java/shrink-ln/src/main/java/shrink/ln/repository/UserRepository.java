package shrink.ln.repository;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import shrink.ln.repository.entities.User;

import javax.validation.constraints.NotBlank;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Executable
    User findByFirstName(@NotBlank String name);
}
