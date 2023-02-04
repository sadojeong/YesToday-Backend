package dev.yestoday.yestoday.core.comment.domain;

import dev.yestoday.yestoday.core.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

//    @JsonBackReference(value = "feed-comment")
//    @ManyToOne(targetEntity = Feed.class)
//    @JoinColumn(name="feed_id")
//    private Feed feed;
//    @Column(name="feed_id",insertable = false, updatable = false)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;
    @Column(name = "user_id",insertable = false, updatable = false)
    private Long userId;
    @Column(name = "comment_desc")
    private String commentDesc;
    @Column(name = "comment_datetime")
    private LocalDateTime commentDateTime;

    @Builder
    public Comment(Long postId, User user, Long userId, String commentDesc, LocalDateTime commentDateTime){
        this.postId = postId;
        this.user = user;
        this.userId = userId;
        this.commentDesc = commentDesc;
        this.commentDateTime = commentDateTime;
    }
}
