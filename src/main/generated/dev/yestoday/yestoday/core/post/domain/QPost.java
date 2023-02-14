package dev.yestoday.yestoday.core.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -1776956814L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final NumberPath<Long> commentNumbers = createNumber("commentNumbers", Long.class);

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageType = createString("imageType");

    public final StringPath imageUrl = createString("imageUrl");

    public final NumberPath<Long> likeNumbers = createNumber("likeNumbers", Long.class);

    public final DateTimePath<java.time.LocalDateTime> postDateTime = createDateTime("postDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> todoId = createNumber("todoId", Long.class);

    public final StringPath todoName = createString("todoName");

    public final dev.yestoday.yestoday.core.user.domain.QUser user;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new dev.yestoday.yestoday.core.user.domain.QUser(forProperty("user")) : null;
    }

}

