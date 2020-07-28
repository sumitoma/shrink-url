package shrink.ln.repository.jpa;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;
import shrink.ln.repository.jpa.entities.User;


@Repository
public interface UserPageableRespository extends PageableRepository<User, String> {
}
