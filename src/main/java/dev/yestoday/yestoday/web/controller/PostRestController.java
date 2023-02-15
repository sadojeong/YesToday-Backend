package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.post.dto.PostDTO;
import dev.yestoday.yestoday.core.post.dto.PostResponse;
import dev.yestoday.yestoday.core.user.application.UserService;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.post.application.PostService;
import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import dev.yestoday.yestoday.core.user.infrastructure.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/posts")
@CrossOrigin("*")
public class PostRestController {
    private final UserRepository userRepository;
    private final PostService postService;
    private final UserService userService;

    public PostRestController(PostService postService, UserService userService,
                              UserRepository userRepository) {
        this.postService = postService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Post> findAll() {return postService.findAll();}


    @PostMapping
    public void save(@RequestBody Post newPost) {
        User user = userRepository.findById(newPost.getUserId()).get();
        newPost.setUser(user);
        postService.save(newPost);
    }

    @DeleteMapping(path = "/{id}")
    public List<Post> delete(@PathVariable("id") Long id){
        return postService.delete((id));
    }

    @PutMapping
    public void update(@RequestBody PostDTO updatePost){
        System.out.println(updatePost);
        postService.update(updatePost);
    }

    @GetMapping(path = "/todo/{todoId}")
    public PostResponse findByTodoId(@PathVariable("todoId")Long todoId){
        return postService.findByTodoId(todoId);
    }

    @GetMapping(path = "/feed/user/{userId}")
    public Page<PostResponse> getFeed(@PathVariable Long userId, @RequestParam int page){
        return postService.getFeed(userId, 5, page);
    }
}
