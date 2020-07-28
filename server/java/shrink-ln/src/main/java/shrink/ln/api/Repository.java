package shrink.ln.api;

import shrink.ln.rest.resources.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface Repository {

    User createUser(@Valid @NotNull User user);

}
