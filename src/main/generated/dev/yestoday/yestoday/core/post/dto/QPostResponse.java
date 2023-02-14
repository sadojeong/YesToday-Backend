package dev.yestoday.yestoday.core.post.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * dev.yestoday.yestoday.core.post.dto.QPostResponse is a Querydsl Projection type for PostResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPostResponse extends ConstructorExpression<PostResponse> {

    private static final long serialVersionUID = 1190275848L;

    public QPostResponse(com.querydsl.core.types.Expression<? extends dev.yestoday.yestoday.core.post.domain.Post> post) {
        super(PostResponse.class, new Class<?>[]{dev.yestoday.yestoday.core.post.domain.Post.class}, post);
    }

}

