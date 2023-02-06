package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.post.dto.PostDTO;
import dev.yestoday.yestoday.core.post.dto.PostResponse;
import dev.yestoday.yestoday.core.user.application.UserService;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.post.application.PostService;
import dev.yestoday.yestoday.core.post.domain.Post;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/posts")
@CrossOrigin("*")
public class PostRestController {
    private final PostService postService;
    private final UserService userService;

    public PostRestController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public List<Post> findAll() {return postService.findAll();}


    @PostMapping
    public void save(@RequestBody Post newPost) {
        System.out.println(newPost.getUserId());
        System.out.println(newPost.getUser());
        postService.save(newPost);
    }

    @DeleteMapping(path = "/{id}")
    public List<Post> delete(@PathVariable("id") Long id){
        return postService.delete((id));
    }

    @PutMapping
    public List<Post> update(@RequestBody PostDTO updatePost){
        return postService.update(updatePost);
    }
}
