package dev.yestoday.yestoday.core.post.infrastructure.querydsl;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.yestoday.yestoday.core.post.dto.PostResponse;
import dev.yestoday.yestoday.core.post.dto.QPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

import static dev.yestoday.yestoday.core.follow.domain.QFollow.follow;
import static dev.yestoday.yestoday.core.post.domain.QPost.post;
import static dev.yestoday.yestoday.core.user.domain.QUser.user;

@RequiredArgsConstructor
public class PostRepositoryQuerydslImpl implements PostRepositoryQuerydsl {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<PostResponse> findPostResponsePageOfFollowingMembers(Long userId, Pageable pageable) {
        final List<PostResponse> posts  = queryFactory
                .select(new QPostResponse(post))
                .from(post)
                .innerJoin(post.user, user)
                .where(post.user.id.in(getFollowingMemberIdsByMemberId(userId)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(post.id.desc())
                .fetch();

        final long total = queryFactory
                .selectFrom(post)
                .innerJoin(post.user, user)
                .where(post.user.id.in(getFollowingMemberIdsByMemberId(userId)))
                .fetchCount();

        return new PageImpl<>(posts, pageable, total);
    }

    private JPQLQuery<Long> getFollowingMemberIdsByMemberId(Long userId) {
        return JPAExpressions
                .select(follow.followUserId)
                .from(follow)
                .where(follow.userId.eq(userId));
    }
}
