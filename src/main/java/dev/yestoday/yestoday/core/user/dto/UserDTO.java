package dev.yestoday.yestoday.core.user.dto;

import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private String nickname;
    private String password;
    private String name;
    private String email;
    private String description;
    private String phoneNumber;
    private String imageUrl;
    private List<Follow> followings;
    private List<Post> posts;

    @Builder
    public UserDTO(String nickname, String password, String name, String email, String description, String phoneNumber, String imageUrl, List<Follow> followings, List<Post> posts){
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.email = email;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.followings = followings;
        this.posts = posts;

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
                .followings(followings)
                .posts(posts)
                .build();
    }
}
