package shrink.ln.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import shrink.ln.rest.resources.User;

import javax.validation.Valid;

@Validated
interface UserApi {
    String BASE_URL = "/users";

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post(processes = MediaType.APPLICATION_JSON)
    HttpResponse<User> createUser(@Valid @Body User user);

}
