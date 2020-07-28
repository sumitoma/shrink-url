package shrink.ln.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import shrink.ln.api.Repository;
import shrink.ln.rest.resources.User;

import javax.inject.Inject;

@Controller(UserApi.BASE_URL)
public class UserController implements UserApi{

    private final Repository repository;

    @Inject
    UserController(Repository repository){
        this.repository = repository;
    }

    @Override
    public HttpResponse<User> createUser(User user) {
        User createdUser = repository.createUser(user);
        return HttpResponse.ok(createdUser);
    }
}
