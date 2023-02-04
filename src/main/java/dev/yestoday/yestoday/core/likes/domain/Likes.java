package dev.yestoday.yestoday.core.likes.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

//    @JsonBackReference(value = "feed-like")
//    @ManyToOne(targetEntity = Feed.class)
//    @JoinColumn(name="feed_id")
//    private Feed feed;

//    @Column(name ="feed_id", insertable = false, updatable = false)
    @Column(name = "post_id")
    private Long postId;


    @JsonBackReference(value = "user-likes")
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Builder
    public Likes(Long postId, User user, Long userId){
        this.postId = postId;
        this.user = user;
        this.userId = userId;
    }
}
