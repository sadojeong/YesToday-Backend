package dev.yestoday.yestoday.core.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.yestoday.yestoday.core.post.domain.Post;

public class PostResponse {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String content;
    @JsonProperty
    private String imageUrl;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
        this.imageUrl = post.getImageUrl();
    }
}
