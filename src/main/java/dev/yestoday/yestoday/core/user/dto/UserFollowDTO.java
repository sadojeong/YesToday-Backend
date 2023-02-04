package dev.yestoday.yestoday.core.user.dto;

import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class UserFollowDTO {
    private UserRepository userRepository;

    private Long id;

    private String nickname;

    private String password;

    public UserFollowDTO(UserRepository userRepository, Long id) {
        System.out.println("UserFollowDTO 생성됨");
        System.out.println(id);
        this.userRepository = userRepository;
        this.id = id;
    }

    public User toUserEntity() {
        String message = String.format("%s에 해당하는 User 가 없습니다.", id);
        System.out.println(id);
        User user =  userRepository.findById(id).orElseThrow(()->new NoSuchElementException(message));
        return user;
    }

}
