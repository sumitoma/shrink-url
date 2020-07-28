package shrink.ln.security;

import javax.validation.constraints.NotBlank;

public interface PasswordEncoder {

    String encode(@NotBlank String password);

    boolean matches(@NotBlank String rawPassword, @NotBlank String encodedPassword);
}
