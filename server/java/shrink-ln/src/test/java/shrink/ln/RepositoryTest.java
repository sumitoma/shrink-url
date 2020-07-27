package shrink.ln;

import io.micronaut.context.BeanContext;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.ExecutableMethod;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import shrink.ln.repository.UserPageableRespository;
import shrink.ln.repository.UserRepository;
import shrink.ln.repository.entities.User;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

@MicronautTest
public class RepositoryTest {

    @Inject
    UserRepository userRepository;

    @Inject
    UserPageableRespository userPageableRespository;

    @Inject
    BeanContext beanContext;

    @BeforeAll
    static void beforeAll(UserRepository userRepository){
        userRepository.saveAll(Arrays.asList(
                new User("sumitsingh", "sumit@gmail.com", "sumit"),
                new User("sumitomar", "sumit@gmail.com", "tomar"),
                new User("sumitoma", "sumit@gmail.com", "sumit")
        ));
    }


    /**
     * Each repo method is computed into byte code at compile time
     * Demonstrate compile time query generation for each repo method
     * Queries are formed by analyzing method signatures
     * find + Projection? + By + Property + OrderBy? + Property?
     */
    @Test
    void testQuery(){
        BeanDefinition<UserRepository> beanDefinition = beanContext.getBeanDefinition(UserRepository.class);
        ExecutableMethod<UserRepository, Object> method = beanDefinition.getRequiredMethod("findByFirstName", String.class);
        String jpaQl = method.getAnnotationMetadata()
                .stringValue(Query.class).orElse(null);

        System.out.println("jpaQl = "+ jpaQl);
    }


    //Crud Repository Test
    @Test
    void testCount(){
        Assertions.assertEquals(3, userRepository.count());
    }

    @Test
    void testFindById(){
        Optional<User> user = userRepository.findById("sumitoma");
        Assertions.assertNotNull(user.get());
        Assertions.assertEquals("sumitoma", user.get().getId());
    }

    @Test
    void testExistsById(){
        boolean exists = userRepository.existsById("sumitoma");
        Assertions.assertTrue(exists);
    }

    @Test
    void testFindByName(){
        User user = userRepository.findByFirstName("sumit");
        Assertions.assertNotNull(user);
        Assertions.assertEquals("sumit", user.getFirstName());

    }

    @Test
    void testFindAll(){
        Iterable<User> users = userRepository.findAll();
        long size = StreamSupport.stream(users.spliterator(), false).count();
        Assertions.assertNotNull(users);
        Assertions.assertEquals(3, size);
    }

    //Pageable Respository Test

    @Test
    void testFindPage(){
        Page<User> page = userPageableRespository.findAll(Pageable.from(0,2 ));
        Assertions.assertEquals(2, page.getContent().size());
        Assertions.assertEquals(2, page.getTotalPages());
        Assertions.assertEquals(3, page.getTotalSize());
    }


}
