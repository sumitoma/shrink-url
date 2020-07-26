package shrink.ln.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shrink.ln.api.utils.Utils;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

@Singleton
class UrlMinifierImpl implements UrlMinifier {

    private final static Logger logger = LoggerFactory.getLogger(UrlMinifierImpl.class);

    @Override
    public String minifyUrl(@NotNull String url) {
      return Utils.hash(url, Utils.HashAlgo.SHA_256).get();
    }
}
