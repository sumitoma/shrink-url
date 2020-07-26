package shrinkln.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import shrinkln.api.UrlMinifier;
import shrinkln.rest.resources.Url;

import javax.inject.Inject;

@Controller(UrlApi.BASE_URL)
public class UrlController implements UrlApi {

    final UrlMinifier urlMinifier;

    @Inject
    UrlController(UrlMinifier urlMinifier){
        this.urlMinifier = urlMinifier;
    }

    @Override
    public HttpResponse<Url> shrinkUrl(Url url) {
        url.setShrinkedUrl(urlMinifier.minifyUrl(url.getUrl()));
        return HttpResponse.ok(url);
    }
}
