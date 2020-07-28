package shrink.ln.security;

import shrink.ln.repository.jpa.entities.User;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

interface UserFetcher {
    Optional<User> findById(@NotBlank String id);
}
