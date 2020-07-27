package shrink.ln.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;
import shrink.ln.repository.entities.User;


@Repository
public interface UserPageableRespository extends PageableRepository<User, String> {
}
