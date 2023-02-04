package dev.yestoday.yestoday.core.comment.dto;

import dev.yestoday.yestoday.core.comment.domain.Comment;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Data
@NoArgsConstructor
public class CommentDTO {
    private Long postId;
    private User user;
    private Long userId;
    private String commentDesc;
    private LocalDateTime commentDateTime;

    @Builder
    public CommentDTO(Long postId, User user, Long userId, String commentDesc, LocalDateTime commentDateTime){
        this.postId = postId;
        this.user = user;
        this.userId = userId;
        this.commentDesc = commentDesc;
        this.commentDateTime = commentDateTime;
    }

    public Comment toCommentEntity(){
        return Comment.builder()
                .postId(postId)
                .user(user)
                .userId(userId)
                .commentDesc(commentDesc)
                .commentDateTime(commentDateTime)
                .build();
    }
}
