package dev.yestoday.yestoday.core.comment.dto;

import dev.yestoday.yestoday.core.comment.domain.Comment;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
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
    private UserDTO user;
    private Long userId;
    private String commentDesc;
    private LocalDateTime commentDateTime;

    @Builder
    public CommentDTO(Long postId, UserDTO user, Long userId, String commentDesc, LocalDateTime commentDateTime){
        this.postId = postId;
        this.user = user;
        this.userId = userId;
        this.commentDesc = commentDesc;
        this.commentDateTime = commentDateTime;
    }

    public CommentDTO(Comment comment) {
        this.postId = comment.getPostId();
        this.user = new UserDTO(comment.getUser());
        this.userId = comment.getUserId();
        this.commentDesc = comment.getCommentDesc();
        this.commentDateTime = comment.getCommentDateTime();
    }

//    public Comment toCommentEntity(){
//        return Comment.builder()
//                .postId(postId)
//                .user(user)
//                .userId(userId)
//                .commentDesc(commentDesc)
//                .commentDateTime(commentDateTime)
//                .build();
//    }
}
