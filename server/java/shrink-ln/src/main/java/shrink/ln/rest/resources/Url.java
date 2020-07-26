package shrink.ln.rest.resources;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;

@Introspected
public class Url {

    @NotNull
    String url;
    String shrinkedUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShrinkedUrl() {
        return shrinkedUrl;
    }

    public void setShrinkedUrl(String shrinkedUrl) {
        this.shrinkedUrl = shrinkedUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", shrinkedUrl='" + shrinkedUrl + '\'' +
                '}';
    }
}
