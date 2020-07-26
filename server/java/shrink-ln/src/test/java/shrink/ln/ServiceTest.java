package shrink.ln;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.io.ResourceLoader;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shrink.ln.rest.UrlClient;
import shrink.ln.rest.resources.Url;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@MicronautTest
public class ServiceTest {

    private final UrlClient urlClient;

    private final ResourceLoader resourceLoader;

    @Inject
    private ServiceTest(UrlClient urlClient, ResourceLoader resourceLoader){
        this.urlClient = urlClient;
        this.resourceLoader = resourceLoader;
    }

    @Test
    void testThrowsException(){
        Url url = new Url();
        Assertions.assertThrows(ConstraintViolationException.class, ()-> urlClient.shrinkUrl(url), "Failed!!");
    }

    @Test
    void testService(){
        Url expectedUrl = getExpectedResource();

        Url url = new Url();
        url.setUrl(expectedUrl.getUrl());

        HttpResponse<Url>  urlResponse = urlClient.shrinkUrl(url);
        Assertions.assertNotNull(urlResponse);
        AssertResource(expectedUrl, urlResponse.body());
    }

    private void AssertResource(Url expectedUrl, Url actualUrl) {
        Assertions.assertEquals(expectedUrl.getShrinkedUrl(), actualUrl.getShrinkedUrl(),
                "Shrinked url does not match");
    }

    private Url getExpectedResource() {
        Optional<URL> resourceUrl = resourceLoader.getResource("Url.json");
        if(!resourceUrl.isPresent()){
            Assertions.fail("Resource json is not present");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(resourceUrl.get(), Url.class);
        } catch (IOException e) {
            Assertions.fail("Failed to load Resource json");
        }
        return null;
    }

}
