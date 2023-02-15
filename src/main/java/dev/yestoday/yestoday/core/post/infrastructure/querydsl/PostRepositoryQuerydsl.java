package dev.yestoday.yestoday.core.post.infrastructure.querydsl;

import dev.yestoday.yestoday.core.post.dto.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryQuerydsl {
    Page<PostResponse> findPostResponsePageOfFollowingMembers(Long memberId, Pageable pageable);


}
