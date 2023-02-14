package dev.yestoday.yestoday.core.user.dto;

import dev.yestoday.yestoday.core.user.domain.Authority;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String nickname;
    private String email;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .nickname(nickname)
                .email(email)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
