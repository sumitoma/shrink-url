package shrinkln.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import shrinkln.rest.resources.Url;

import javax.validation.Valid;

@Validated
interface UrlApi{

    String BASE_URL = "/shrinkurl";

    @Post(processes = MediaType.APPLICATION_JSON)
    HttpResponse<Url> shrinkUrl(@Valid @Body Url url);
}
