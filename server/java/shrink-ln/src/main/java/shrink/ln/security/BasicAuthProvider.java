package shrink.ln.security;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
public class BasicAuthProvider implements AuthenticationProvider {

    private final static Logger logger = LoggerFactory.getLogger(BasicAuthProvider.class);

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        logger.info("Authenticating.."+authenticationRequest.getIdentity() + " "+ authenticationRequest.getIdentity());
        if(authenticationRequest.getIdentity().equals("sumitoma")
                && authenticationRequest.getSecret().equals("password")){

            return Flowable.just(new UserDetails((String)authenticationRequest.getIdentity(), Arrays.asList("ROLE_USER")));
        }
        return Flowable.just(new AuthenticationFailed());
    }
}
