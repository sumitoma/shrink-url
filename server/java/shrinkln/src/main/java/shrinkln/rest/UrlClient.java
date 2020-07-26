package shrinkln.rest;

import io.micronaut.http.client.annotation.Client;

@Client(UrlApi.BASE_URL)
public interface UrlClient extends UrlApi{
}
