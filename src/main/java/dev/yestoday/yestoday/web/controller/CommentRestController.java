package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.comment.application.CommentService;
import dev.yestoday.yestoday.core.comment.domain.Comment;
import dev.yestoday.yestoday.core.comment.dto.CommentDTO;
import dev.yestoday.yestoday.core.post.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/comments")
@CrossOrigin("*")
public class CommentRestController {
    private final CommentService service;

    public CommentRestController(CommentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comment> findAll(){
        log.debug("--GET: localhost:8080/api/feeds, findAll() called.");
        return service.findAll();
    }

    @PostMapping
    public List<Comment> save(@RequestBody CommentDTO newComment){
        log.debug("--POST: localhost:8080/api/feeds, save() called");
        log.debug("--@RequestBody Feed: {}", newComment);

        return service.save(newComment);

    }

    @DeleteMapping(path = "/{commentId}")
    public List<Comment> delete(@PathVariable("commentId") Long commentId){
        log.debug("--POST: localhost:8080/api/feeds, delete() called");
        log.debug("--@RequestParam feedID: {}",commentId);
        return service.delete(commentId);

    }

    @GetMapping(path = "feeds/{feedId}")
    public List<Comment> findByFeedId(@PathVariable("feedId")Long feedId){
        return service.findByPostId(feedId);
    }
}
