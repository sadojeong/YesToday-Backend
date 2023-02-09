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

    @GetMapping("following-check/{userId}/{followUserId}")
    public boolean checkFollow(@PathVariable Long userId, @PathVariable Long followUserId) {
        return followService.checkFollow(userId, followUserId);
    }

    @PostMapping
    public void save(@RequestBody Follow newFollow) {
        followService.save(newFollow);
    }

    @DeleteMapping("{userId}/{followUserId}")
    public void delete(@PathVariable Long userId, @PathVariable Long followUserId){
        log.debug("--delete: localhost:8080/api/feeds, delete() called");
        followService.delete(userId, followUserId);
    }

    @GetMapping(path = "users/{userId}")
    public List<Follow> findByUserID(@PathVariable("userId") Long userId){
        log.debug("--GET: localhost:8080/api/users, findById() called.");

        return followService.findByUserId(userId);
    }
}
