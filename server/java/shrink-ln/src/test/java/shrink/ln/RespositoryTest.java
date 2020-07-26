package shrink.ln;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shrink.ln.repository.UserRepository;
import shrink.ln.repository.entities.User;

import javax.inject.Inject;
import java.util.Arrays;

@MicronautTest
public class RespositoryTest {

    @Inject
    UserRepository userRepository;

    @BeforeAll
    static void beforeAll(UserRepository userRepository){
        userRepository.saveAll(Arrays.asList(
                new User("sumitoma", "sumit@gmail.com", "sumit"),
                new User("sumitomar", "sumit@gmail.com", "tomar")
        ));
    }

    @Test
    void testCount(){
        Assertions.assertEquals(2, userRepository.count());
    }

}
