package dev.yestoday.yestoday.core.follow.domain;

import dev.yestoday.yestoday.core.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name="follows")
public class Follow {

    @Id
    @Column(name = "follow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "follow_user_id")
    private User followUser;

    @Column(name = "follow_user_id", insertable = false, updatable = false)
    private Long followUserId;

    @Builder
    public Follow(User user, Long userId, User followUser, Long followUserId){
        this.user = user;
        this.userId = userId;
        this.followUser = followUser;
        this.followUserId = followUserId;
    }
}
