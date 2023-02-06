package dev.yestoday.yestoday.core.user.dto;

import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nickname;
    private String password;
    private String name;
    private String email;
    private String description;
    private String phoneNumber;
    private String imageUrl;
//    private List<Follow> followings;
//    private List<Post> posts;

    private UserRepository userRepository;


    @Builder
    public UserDTO(User user){
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.name = user.getName();
        this.email = user.getEmail();
        this.description = user.getDescription();
        this.phoneNumber = user.getPhoneNumber();
        this.imageUrl = user.getImageUrl();
    }

    public User toUserEntity() {
        return User.builder()
                .nickname(nickname)
                .password(password)
                .name(name)
                .email(email)
                .description(description)
                .phoneNumber(phoneNumber)
                .imageUrl(imageUrl)
                .build();
    }
}
