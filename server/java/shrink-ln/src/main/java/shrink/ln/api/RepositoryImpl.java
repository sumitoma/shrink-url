package shrink.ln.api;

import shrink.ln.repository.jpa.UserRepository;
import shrink.ln.rest.resources.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RepositoryImpl implements Repository {

    UserRepository userRepository;

    @Inject
    RepositoryImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(@Valid @NotNull User user) {
        shrink.ln.repository.jpa.entities.User userEntity = new shrink.ln.repository.jpa.entities.User();
        userEntity.setId(user.getEmail());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userRepository.save(userEntity);
        return user;
    }
}
