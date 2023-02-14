package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.todo.application.TodoService;
import dev.yestoday.yestoday.core.todo.domain.Todo;

import dev.yestoday.yestoday.core.todo.dto.TodoDTO;
import dev.yestoday.yestoday.core.todo.dto.TodoUpdateRequest;
import dev.yestoday.yestoday.core.todo.infrastrucuture.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j //logging 남기는 어노테이션
@RestController
@RequestMapping(path = "/api/todo")
@CrossOrigin("*")
public class TodoRestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final TodoService service;

    private final TodoRepository todoRepository;

    public TodoRestController(TodoService service, TodoRepository todoRepository) {
        this.service = service;
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> findAll() {
        log.debug("--GET: localhost:8080/api/todo, findAll() called.");
        return service.findAll();
    }

    //Post - save()
    @PostMapping
    public List<Todo> save(@RequestBody Todo newTodo){
        logger.info("--POST: localhost:8080/api/todo, save() called");
        logger.info("--@RequestBody User: {}", newTodo);
        return service.save(newTodo);

    }

    //Put - update()
    @PutMapping
    public void update(@RequestBody TodoUpdateRequest updateTodo){
        logger.info("--POST: localhost:8080/api/todo, update() called");
        logger.info("--@RequestBody User: {}", updateTodo);
        service.update(updateTodo);
    }

    @PutMapping("/todocomplete")
    public List<Todo> completeUpdate(@RequestParam("id") long id) {
        Todo completeUpdateTodo =service.findById(id);
        completeUpdateTodo.setCompleteState(!completeUpdateTodo.isCompleteState());

        return service.save(completeUpdateTodo);
    }

    @DeleteMapping
    //Delete - delete()
    public List<Todo> delete(@RequestParam("id") long id){
        logger.info("--POST: localhost:8080/api/todo, delete() called");
        logger.info("--@RequestParam(id): {}", id);
        return service.delete(id);

    }

    @GetMapping(path="users/{userId}/todo-date/{todoDate}")
    public List<Todo> findByUserIdAndTodoDate(@PathVariable("userId")Long userId, @PathVariable("todoDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate todoDate){
        return service.findByUserIdAndTodoDate(userId, todoDate);
    }

    @GetMapping(path="users/{userId}/not-posted-todos/todo-date/{todoDate}")
    public List<Todo> findByUserIdAndIsPosted(@PathVariable("userId")Long userId, @PathVariable("todoDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate todoDate){
        return service.findByUserIdAndIsPosted(userId, todoDate);
    }

    @PutMapping(path="id/{todoId}/post")
    public Todo updatePost(@PathVariable("todoId") Long todoId, @RequestParam("isPosted")boolean isPosted){
        return service.updatePost(todoId,isPosted);
    }

    @GetMapping(path="/id/{todoId}")
    public Todo findById(@PathVariable("todoId")Long todoId){
        return service.findById(todoId);
    }



}
