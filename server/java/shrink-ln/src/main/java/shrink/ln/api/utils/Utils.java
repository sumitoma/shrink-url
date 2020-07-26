package shrink.ln.api.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class Utils {
    private Utils(){ }

    public static enum HashAlgo {
        SHA_256("SHA-256");

        String value;
        HashAlgo(String value) {
            this.value = value;
        }
    }

    public static Optional<String> hash(String input, HashAlgo hashAlgo){
        String output = null;
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance(hashAlgo.value);
            final byte[] hashBytes = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
            output = toHexString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(output);
    }

    private static String toHexString(byte[] hashBytes) {
        BigInteger number = new BigInteger(1, hashBytes);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length()< 32){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
