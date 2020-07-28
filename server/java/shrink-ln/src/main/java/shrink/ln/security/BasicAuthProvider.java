package shrink.ln.security;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shrink.ln.repository.jpa.entities.User;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@Singleton
public class BasicAuthProvider implements AuthenticationProvider {

    private final static Logger logger = LoggerFactory.getLogger(BasicAuthProvider.class);

    protected final UserFetcher userFetcher;
    protected final PasswordEncoder passwordEncoder;
    protected final Scheduler scheduler;

    @Inject
    BasicAuthProvider(UserFetcher userFetcher, PasswordEncoder passwordEncoder,
                      @Named(TaskExecutors.IO) ExecutorService executorService){
        this.passwordEncoder = passwordEncoder;
        this.userFetcher = userFetcher;
        this.scheduler = Schedulers.from(executorService);
    }


    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {

        return Flowable.create(flowableEmitter -> {
            final Optional<User> user = userFetcher.findById(authenticationRequest.getIdentity().toString());
            final Optional<AuthenticationFailed> authenticationFailed = validate(user, authenticationRequest);
            if(authenticationFailed.isPresent()){
                flowableEmitter.onError(new AuthenticationException(authenticationFailed.get()));
            } else {
                flowableEmitter.onNext(prepareSuccessfulAuthReponse(authenticationRequest, user));
            }
            flowableEmitter.onComplete();
        }, BackpressureStrategy.ERROR).cast(AuthenticationResponse.class).subscribeOn(scheduler);
    }

    private AuthenticationResponse prepareSuccessfulAuthReponse(AuthenticationRequest<?,?> authenticationRequest, Optional<User> user) {
        return new UserDetails(user.get().getId(), List.of());
    }

    private Optional<AuthenticationFailed> validate(final Optional<User> user, final AuthenticationRequest<?,?> authenticationRequest) {
        AuthenticationFailed authenticationFailed = null;
        if(!user.isPresent()){
            authenticationFailed = new AuthenticationFailed(AuthenticationFailureReason.USER_NOT_FOUND);
        } else if(!passwordEncoder.matches(authenticationRequest.getSecret().toString(), user.get().getPassword())){
            authenticationFailed = new AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH);
        }
        return Optional.ofNullable(authenticationFailed);
    }
}
