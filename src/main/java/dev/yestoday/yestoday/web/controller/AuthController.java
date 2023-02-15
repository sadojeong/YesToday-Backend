package dev.yestoday.yestoday.web.controller;


import dev.yestoday.yestoday.core.user.dto.UserRequestDto;
import dev.yestoday.yestoday.core.user.dto.UserResponseDto;
import dev.yestoday.yestoday.core.user.dto.TokenRequestDto;
import dev.yestoday.yestoday.core.user.dto.TokenDto;
import dev.yestoday.yestoday.core.user.application.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(authService.signup(userRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserRequestDto userRequestDto) {
        System.out.println("login 호출됨");
        return ResponseEntity.ok(authService.login(userRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}
