package dev.yestoday.yestoday.core.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.yestoday.yestoday.core.post.domain.Post;

import java.time.LocalDateTime;

public class PostResponse {
    @JsonProperty
    private Long id;
    @JsonProperty
    private Long userId;
    @JsonProperty
    private String todoName;
    @JsonProperty
    private String content;
    @JsonProperty
    private String imageUrl;
    @JsonProperty
    private Long likeNumbers;
    @JsonProperty
    private Long commentNumbers;
    @JsonProperty
    private LocalDateTime postDateTime;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.userId = post.getUserId();
        this.todoName = post.getTodoName();
        this.content = post.getContent();
        this.imageUrl = post.getImageUrl();
        this.likeNumbers = post.getLikeNumbers();
        this.commentNumbers = post.getCommentNumbers();
        this.postDateTime = post.getPostDateTime();
    }
}
