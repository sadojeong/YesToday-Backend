package dev.yestoday.yestoday.core.todo.domain;

import dev.yestoday.yestoday.core.user.domain.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Todo {
    //투두 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

    //회원 id
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    //투두 내용
    @Column(name = "todo_name")
    private String name;

    //완료여부
    @Column(name = "complete_state", nullable = false)
    @ColumnDefault("false")
    private boolean completeState;

    //등록날짜
//    private String todo_datetime;

    //투두 상세내용
    @Column(name = "todo_description", nullable = true)
    private String todoDescription;

    @Column(name="todo_date",nullable = false)
    private LocalDate todoDate;

    @Builder
    public Todo(User user, Long userId, String name, boolean completeState, String todoDescription ,LocalDate todoDate) {
        this.user = user;
        this.userId = userId;
        this.name = name;
        this.completeState = completeState;
        this.todoDescription = todoDescription;
        this.todoDate = todoDate;
    }
}
