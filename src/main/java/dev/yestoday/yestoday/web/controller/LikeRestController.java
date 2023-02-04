package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.likes.application.LikesService;
import dev.yestoday.yestoday.core.likes.domain.Likes;
import dev.yestoday.yestoday.core.likes.dto.LikesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/likes")
@CrossOrigin("*")
public class LikeRestController {
    private final LikesService service;

    public LikeRestController(LikesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Likes> findAll(){
        return service.findAll();
    }

    @PostMapping
    public List<Likes> save(@RequestBody LikesDTO newLikes){
        return service.save(newLikes);

    }

    @DeleteMapping(path = "/{likesId}")
    public List<Likes> delete(@PathVariable("likesId") Long likesId){

        return service.delete(likesId);

    }

    @GetMapping(path = "users/{userId}")
    public List<Likes> findByUserId(@PathVariable("userId")Long userId){
        return service.findByUserId(userId);
    }

    @GetMapping(path="users/{userId}/posts/{postId}")
    public boolean findByUserIdAndPostId(@PathVariable("userId")Long userId, @PathVariable("postId")Long postId){
        return service.findByUserIdAndPostId(userId, postId);
    }
}
