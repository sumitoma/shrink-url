package shrink.ln.rest;

import io.micronaut.http.client.annotation.Client;

@Client(UserApi.BASE_URL)
public interface UserClient extends UserApi{
}
