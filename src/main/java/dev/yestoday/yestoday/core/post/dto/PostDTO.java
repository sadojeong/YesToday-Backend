package dev.yestoday.yestoday.core.post.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private Long todoId;
    private String todoName;
    private User user;
    private Long userId;
    private String content;
    private String imageUrl;
    private String imageType;
    private Long likeNumbers;
    private Long commentNumbers;
    private LocalDateTime postDateTime;

    @Builder
    public PostDTO(Long id, Long todoId, String todoName, User user, Long userId, String content,
                   String imageUrl, String imageType, Long likeNumbers, Long commentNumbers, LocalDateTime postDateTime){
        this.id = id;
        this.todoId = todoId;
        this.todoName = todoName;
        this.user = user;
        this.userId = userId;
        this.content = content;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.likeNumbers = likeNumbers;
        this.commentNumbers = commentNumbers;
        this.postDateTime = postDateTime;
    }

    public Post toPostEntity(){
        return Post.builder()

                .todoId(todoId)
                .todoName(todoName)
                .user(user)
                .userId(userId)
                .content(content)
                .imageUrl(imageUrl)
                .imageType(imageType)
                .likeNumbers(likeNumbers)
                .commentNumbers(commentNumbers)
                .postDateTime(postDateTime)
                .build();
    }
}
