package dev.yestoday.yestoday.core.likes.dto;

import dev.yestoday.yestoday.core.likes.domain.Likes;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class LikesDTO {
    private Long postId;
    private User user;
    private Long userId;

    @Builder
    public LikesDTO(Long postId, User user, Long userId){
        this.postId = postId;
        this.user = user;
        this.userId = userId;
    }

    public Likes toLikesEntity(){
        return Likes.builder()
                .postId(postId)
                .user(user)
                .userId(userId)
                .build();
    }
}
