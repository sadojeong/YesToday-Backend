package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.follow.application.FollowService;
import dev.yestoday.yestoday.core.follow.domain.Follow;
import dev.yestoday.yestoday.core.follow.dto.FollowDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/follows")
@CrossOrigin("*")
public class FollowRestController {
    private final FollowService followService;

    public FollowRestController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping
    public List<Follow>  findAll() {
        return followService.findAll();
    }

    @GetMapping("number-of-follower/{id}")
    public int getNumberOfFollwer(@PathVariable Long id) {
        return followService.numberOfFollower(id);
    }

    @PostMapping
    public void save(@RequestBody Follow newFollow) {
        followService.save(newFollow);
    }

    @DeleteMapping(path = "/{followId}")
    public List<Follow> delete(@PathVariable("followId") Long followId){
        log.debug("--POST: localhost:8080/api/feeds, delete() called");
        log.debug("--@RequestParam feedID: {}",followId);
        return followService.delete(followId);

    }

    @GetMapping(path = "users/{userId}")
    public List<Follow> findByUserID(@PathVariable("userId") Long userId){
        log.debug("--GET: localhost:8080/api/users, findById() called.");

        return followService.findByUserId(userId);
    }
}
