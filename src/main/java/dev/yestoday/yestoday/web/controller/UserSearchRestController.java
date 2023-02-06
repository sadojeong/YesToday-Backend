package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.user.application.UserService;
import dev.yestoday.yestoday.core.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Slf4j
@RestController
@RequestMapping(path = "/users-search")
@CrossOrigin("*")
public class UserSearchRestController {

    private final UserService service;

    public UserSearchRestController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/nickname/{nickname}")
    public List<User> findByNicknameContaining(@PathVariable("nickname") String nickname){
        return service.findByNicknameContaining(nickname);
    }
}
