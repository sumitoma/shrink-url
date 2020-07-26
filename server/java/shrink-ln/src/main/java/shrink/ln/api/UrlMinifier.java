package shrink.ln.api;

import javax.validation.constraints.NotNull;

public interface UrlMinifier {

    String minifyUrl(@NotNull String url);
}
