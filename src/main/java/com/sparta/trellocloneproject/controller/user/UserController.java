package com.sparta.trellocloneproject.controller.user;



import com.sparta.trellocloneproject.service.user.UserService;
import com.sparta.trellocloneproject.dto.login.SignupRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("user/signup")
    public String signup(@RequestBody SignupRequestDto requestdto) {

        userService.signup(requestdto);

        return "회원가입 완료";

    }

}