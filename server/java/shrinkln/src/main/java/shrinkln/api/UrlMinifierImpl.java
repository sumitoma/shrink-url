package shrinkln.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Singleton
class UrlMinifierImpl implements UrlMinifier {

    private final static Logger logger = LoggerFactory.getLogger(UrlMinifierImpl.class);

    @Override
    public String minifyUrl(@NotNull String url) {
        String sha_256hex = null;
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            final byte[] hashBytes = messageDigest.digest(url.getBytes(StandardCharsets.UTF_8));
            sha_256hex = toHexString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Failed to minify url", e);
        }
        return sha_256hex;
    }

    private String toHexString(byte[] hashBytes) {
        BigInteger number = new BigInteger(1, hashBytes);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length()< 32){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
