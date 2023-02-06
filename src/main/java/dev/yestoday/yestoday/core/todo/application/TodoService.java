package dev.yestoday.yestoday.core.todo.application;

import dev.yestoday.yestoday.core.todo.dto.TodoDTO;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.todo.domain.Todo;
import dev.yestoday.yestoday.core.todo.infrastrucuture.TodoRepository;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    private UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository){
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }
    public List<Todo> save(Todo newTodo) {
        User user = userRepository.findById(newTodo.getUserId()).get();
        newTodo.setUser(user);
        todoRepository.save(newTodo);

        return todoRepository.findAll();
    }

    public List<Todo> update(Todo updateTodo) {
        User user = userRepository.findById(updateTodo.getUserId()).get();
        updateTodo.setUser(user);
        todoRepository.save(updateTodo);

        return todoRepository.findAll();
    }

    public List<Todo> delete(Long id) {

        todoRepository.deleteById(id);

        return todoRepository.findAll();
    }

    public Todo findById(Long id) {
        String message = String.format("%s에 해당하는 Todo가 없습니다.", id);

        Todo todo = todoRepository.findById(id).orElseThrow(()->new NoSuchElementException(message));
        return todo;
    }

    public List<Todo> findByUserIdAndTodoDate(Long userId, LocalDate todoDate){
        String message = String.format("%s에 해당하는 오늘의 todo가 없습니다.", userId);

        List<Todo> todos = todoRepository.findByUserIdAndTodoDate(userId, todoDate);

        if(todos.isEmpty()){
            new NoSuchElementException(message);
        }
        return todos;

    }


}
