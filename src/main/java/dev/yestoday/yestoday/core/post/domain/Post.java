package dev.yestoday.yestoday.core.post.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "todo_id")
    private Long todoId;
    @Column(name = "todo_name")
    private String todoName;

    @JsonBackReference(value = "user-post")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "post_content")
    private String content;

    @Column(name = "img_Url", nullable = false)
    private String imageUrl;
    @Column(name="img_type", nullable = false)
    private String imageType;

    @Column(name = "like_numbers" , nullable = true)
    @ColumnDefault("0")
    private Long likeNumbers;
    @Column(name = "comment_numbers" , nullable = true)
    @ColumnDefault("0")
    private Long commentNumbers;
    @Column(name = "post_datetime" , nullable = false)
    private LocalDateTime postDateTime;

    @Builder
    public Post(Long todoId, String todoName, User user, Long userId , String content, String imageUrl,
                String imageType, Long likeNumbers, Long commentNumbers, LocalDateTime postDateTime){
        this.todoId = todoId;
        this.todoName = todoName;
        this.user = user;
        this.userId = userId;
        this.content = content;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.likeNumbers =  likeNumbers;
        this.commentNumbers = commentNumbers;
        this.postDateTime = postDateTime;
    }
}
