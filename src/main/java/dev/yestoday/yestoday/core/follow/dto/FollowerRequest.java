package dev.yestoday.yestoday.core.follow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.user.domain.User;

public class FollowerRequest {
    @JsonProperty
    private Long id;

    @JsonProperty
    private User followUser;

    public FollowerRequest(Follow follow) {
        this.id = follow.getId();
        this.followUser = follow.getFollowUser();
    }
}
