package shrink.ln.security;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Singleton
class PasswordEncoderImpl implements PasswordEncoder{

    @Override
    public String encode(@NotBlank String password) {
        return password;
    }

    @Override
    public boolean matches(@NotBlank String rawPassword, @NotBlank String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
