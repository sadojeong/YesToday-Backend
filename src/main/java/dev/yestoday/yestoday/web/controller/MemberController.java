package dev.yestoday.yestoday.web.controller;

import dev.yestoday.yestoday.core.member.dto.MemberResponseDto;
import dev.yestoday.yestoday.core.member.service.MemberService;
import dev.yestoday.yestoday.core.member.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> findMemberInfoById() {
        return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberResponseDto> findMemberInfoByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findMemberInfoByEmail(email));
    }
}
