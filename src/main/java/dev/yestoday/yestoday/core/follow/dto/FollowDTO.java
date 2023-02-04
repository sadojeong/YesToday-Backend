package dev.yestoday.yestoday.core.follow.dto;

import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.user.dto.UserFollowDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class FollowDTO {
    private UserFollowDTO user;
    private Long userId;
    private UserFollowDTO followUser;
    private Long followUserId;

    @Builder
    public FollowDTO(UserFollowDTO user, Long userId, UserFollowDTO followUser, Long followUserId) {
        this.user = user;
        this.userId = userId;
        this.followUser = followUser;
        this.followUserId = followUserId;
    }

    public Follow toFollowEntity() {
        return Follow.builder()
                .user(user.toUserEntity())
//                .userId(userId)
                .followUser(followUser.toUserEntity())
//                .followUserId(followUserId)
                .build();
    }
}
