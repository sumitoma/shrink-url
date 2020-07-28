package shrink.ln.security;

import shrink.ln.repository.jpa.UserRepository;
import shrink.ln.repository.jpa.entities.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Singleton
class UserFetcherImpl implements UserFetcher{

    private final UserRepository userRepository;

    @Inject
    UserFetcherImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(@NotBlank String id) {
         return userRepository.findById(id);
    }
}
