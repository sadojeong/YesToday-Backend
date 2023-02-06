package dev.yestoday.yestoday.core.user.dto;

import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class UserFollowDTO {
    private Long id;

    private String nickname;

    private String imageUrl;

    private List<Post> posts;

    public UserFollowDTO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.imageUrl = user.getImageUrl();
        this.posts = user.getPosts();
    }
}
