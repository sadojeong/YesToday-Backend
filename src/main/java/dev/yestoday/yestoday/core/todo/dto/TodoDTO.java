package dev.yestoday.yestoday.core.todo.dto;

import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.todo.domain.Todo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TodoDTO {
    private User user;
    private Long userId;
    private String name;
    private boolean completeState;
    private String todoDescription;
    private LocalDate todoDate;

    @Builder
    public TodoDTO(User user,Long userId, String name, boolean completeState, String todoDescription, LocalDate todoDate){
        this.user = user;
        this.userId = userId;
        this.name = name;
        this.completeState = completeState;
        this.todoDescription = todoDescription;
        this.todoDate = todoDate;
    }

    public Todo toTodoEntity(){
        return Todo.builder()
                .user(user)
                .userId(userId)
                .name(name)
                .completeState(completeState)
                .todoDescription(todoDescription)
                .todoDate(todoDate)
                .build();
    }
}
