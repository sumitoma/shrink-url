package shrink.ln.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import shrink.ln.rest.resources.User;

@Controller(UserApi.BASE_URL)
public class UserController implements UserApi{
    @Override
    public HttpResponse<User> createUser(User user) {
        return null;
    }
}
