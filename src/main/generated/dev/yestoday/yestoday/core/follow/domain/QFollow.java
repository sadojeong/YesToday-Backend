package dev.yestoday.yestoday.core.follow.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFollow is a Querydsl query type for Follow
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFollow extends EntityPathBase<Follow> {

    private static final long serialVersionUID = -527129388L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFollow follow = new QFollow("follow");

    public final dev.yestoday.yestoday.core.user.domain.QUser followUser;

    public final NumberPath<Long> followUserId = createNumber("followUserId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final dev.yestoday.yestoday.core.user.domain.QUser user;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QFollow(String variable) {
        this(Follow.class, forVariable(variable), INITS);
    }

    public QFollow(Path<? extends Follow> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFollow(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFollow(PathMetadata metadata, PathInits inits) {
        this(Follow.class, metadata, inits);
    }

    public QFollow(Class<? extends Follow> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.followUser = inits.isInitialized("followUser") ? new dev.yestoday.yestoday.core.user.domain.QUser(forProperty("followUser")) : null;
        this.user = inits.isInitialized("user") ? new dev.yestoday.yestoday.core.user.domain.QUser(forProperty("user")) : null;
    }

}

