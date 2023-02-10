package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.follow.dto.FollowerRequest;
import dev.yestoday.yestoday.core.post.dto.PostResponse;
import dev.yestoday.yestoday.core.user.application.UserService;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
import dev.yestoday.yestoday.core.user.dto.UserFollowDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/users")
@CrossOrigin("*")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

//    @GetMapping("/{username}")
//    public Member findMember(@PathVariable String username) {
//        return memberService.findUser(username);
//    }

    @GetMapping("byid/{id}") // GET: members/1
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("bynickname/{nickname}") // users?username=jung
    public UserDTO findByNickname(@PathVariable String nickname) {return userService.findByNickname(nickname);}

    @GetMapping("following-members/{id}")
    public List<UserFollowDTO> getFollowingsById(@PathVariable Long id) {return userService.getFollowingsById(id);}

    @GetMapping("following-posts/{id}")
    public List<FollowerRequest> getFollowingPostById(@PathVariable Long id) {return userService.getFollowingPostById(id);}

    @GetMapping("follower-members/{id}")
    public List<UserFollowDTO> getFollowersById(@PathVariable Long id) {return userService.getFollowersById(id);}

    @GetMapping("postsinfo/{id}")
    public List<PostResponse> getPostsById(@PathVariable Long id) {return userService.getPostsById(id);}

    @PostMapping
    public void save(@RequestBody UserDTO newUser) {
        userService.save(newUser);
    }

    @PutMapping
    public void update(@RequestBody UserDTO updateUser) {userService.update(updateUser);}

    @DeleteMapping("byid/{id}")
    public void delete(@PathVariable("id")Long id){
        userService.delete(id);
    }
}
