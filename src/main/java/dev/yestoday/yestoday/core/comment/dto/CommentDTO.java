package dev.yestoday.yestoday.core.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    private Long postId;
    private UserDTO user;
    private Long userId;
    private String commentDesc;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime commentDateTime;

    @Builder
    public CommentDTO(Long id,Long postId, UserDTO user, Long userId, String commentDesc, LocalDateTime commentDateTime){
        this.id = id;
        this.postId = postId;
        this.user = user;
        this.userId = userId;
        this.commentDesc = commentDesc;
        this.commentDateTime = commentDateTime;
    }

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
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
