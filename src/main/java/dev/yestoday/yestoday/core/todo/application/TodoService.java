package dev.yestoday.yestoday.core.todo.application;

import dev.yestoday.yestoday.core.todo.dto.TodoDTO;
import dev.yestoday.yestoday.core.todo.dto.TodoUpdateRequest;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.todo.domain.Todo;
import dev.yestoday.yestoday.core.todo.infrastrucuture.TodoRepository;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

        return  todoRepository.findByUserIdAndTodoDate(newTodo.getUserId(), newTodo.getTodoDate());
    }

    public void update(TodoUpdateRequest updateTodo) {
        Todo saveTodo = todoRepository.findById(updateTodo.getId()).get();
        saveTodo.setName(updateTodo.getName());
        saveTodo.setTodoDescription(updateTodo.getTodoDescription());


        todoRepository.save(saveTodo);
    }

    public List<Todo> delete(Long id) {
        Todo todo = todoRepository.findById((id)).get();
        todoRepository.deleteById(id);

        return  todoRepository.findByUserIdAndTodoDate(todo.getUserId(), todo.getTodoDate());
    }

    public Todo findById(Long id) {
        String message = String.format("%s에 해당하는 Todo가 없습니다.", id);

        Todo todo = todoRepository.findById(id).orElseThrow(()->new NoSuchElementException(message));
        return todo;
    }

    public List<Todo> findByUserIdAndTodoDate(Long userId, LocalDate todoDate){
    

        List<Todo> todos = todoRepository.findByUserIdAndTodoDate(userId, todoDate);

        return todos;
    }

    public List<Todo> findByUserIdAndIsPosted(Long userId, LocalDate todoDate){
        List<Todo> todos = findByUserIdAndTodoDate(userId, todoDate);
        List<Todo> notPostedTodos = new ArrayList<>();

        for (Todo todo:todos){
            if(!todo.isPosted()){
                notPostedTodos.add(todo);
            }
        }

        return notPostedTodos;
    }

    public void updatePost(Long todoId, boolean isPosted){
        Todo updateTodo = todoRepository.findById(todoId).get();
        updateTodo.setPosted(isPosted);

        todoRepository.save(updateTodo);

    }


}
