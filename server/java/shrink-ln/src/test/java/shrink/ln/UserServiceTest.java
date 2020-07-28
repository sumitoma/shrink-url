package shrink.ln;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shrink.ln.rest.UserClient;
import shrink.ln.rest.resources.User;

import javax.inject.Inject;

@MicronautTest
public class UserServiceTest {

    private final UserClient userClient;

    @Inject UserServiceTest(UserClient userClient){
        this.userClient = userClient;
    }

    @Test
    void testCreateUser(){
        User user = new User();
        user.setEmail("sumit@gmail.com");
        user.setFirstName("sumit");
        user.setPassword("tomar");

        HttpResponse<User> response = userClient.createUser(user);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatus());

    }

}
