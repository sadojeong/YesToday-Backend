package dev.yestoday.yestoday.core.todo.dto;

import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.todo.domain.Todo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDTO {
    private User user;
    private Long userId;
    private String name;
    private boolean completeState;
    private String todoDescription;

    @Builder
    public TodoDTO(User user,Long userId, String name, boolean completeState, String todoDescription){
        this.user = user;
        this.userId = userId;
        this.name = name;
        this.completeState = completeState;
        this.todoDescription = todoDescription;
    }

    public Todo toTodoEntity(){
        return Todo.builder()
                .user(user)
                .userId(userId)
                .name(name)
                .completeState(completeState)
                .todoDescription(todoDescription)
                .build();
    }
}
