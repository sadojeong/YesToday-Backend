package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.user.application.UserService;
import dev.yestoday.yestoday.core.user.domain.User;
import dev.yestoday.yestoday.core.user.dto.UserDTO;
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
    public List<User> findAll() {
        return userService.findAll();
    }

//    @GetMapping("/{username}")
//    public Member findMember(@PathVariable String username) {
//        return memberService.findUser(username);
//    }

    @GetMapping("byid/{id}") // GET: members/1
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("bynickname/{nickname}") // users?username=jung
    public User findByNickname(@PathVariable String nickname) {return userService.findByNickname(nickname);}

    @PostMapping
    public List<User> save(@RequestBody UserDTO newUser) {
        return userService.save(newUser);
    }

    @DeleteMapping("byid/{id}")
    public List<User> delete(@PathVariable("id")Long id){
        return userService.delete(id);
    }
}
