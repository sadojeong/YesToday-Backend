package dev.yestoday.yestoday.core.user.dto;

import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.post.dto.PostResponse;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
public class UserFollowDTO {
    private Long id;

    private String nickname;

    private String imageUrl;

    private List<PostResponse> posts;

    public UserFollowDTO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.imageUrl = user.getImageUrl();

        List<PostResponse> returnPosts = new ArrayList<>();

        List<Post> posts = user.getPosts();

        for (Post post: posts
        ) {
            returnPosts.add(new PostResponse(post));
        }

        this.posts = returnPosts;
    }
}
