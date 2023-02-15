package dev.yestoday.yestoday.core.todo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTodo is a Querydsl query type for Todo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTodo extends EntityPathBase<Todo> {

    private static final long serialVersionUID = 936452286L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTodo todo = new QTodo("todo");

    public final BooleanPath completeState = createBoolean("completeState");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isPosted = createBoolean("isPosted");

    public final StringPath name = createString("name");

    public final DatePath<java.time.LocalDate> todoDate = createDate("todoDate", java.time.LocalDate.class);

    public final StringPath todoDescription = createString("todoDescription");

    public final dev.yestoday.yestoday.core.user.domain.QUser user;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QTodo(String variable) {
        this(Todo.class, forVariable(variable), INITS);
    }

    public QTodo(Path<? extends Todo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTodo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTodo(PathMetadata metadata, PathInits inits) {
        this(Todo.class, metadata, inits);
    }

    public QTodo(Class<? extends Todo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new dev.yestoday.yestoday.core.user.domain.QUser(forProperty("user")) : null;
    }

}

