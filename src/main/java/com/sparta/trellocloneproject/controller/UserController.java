package com.sparta.trellocloneproject.controller;



import com.sparta.trellocloneproject.service.UserService;
import com.sparta.trellocloneproject.dto.SignupRequestDto;

import com.sparta.trellocloneproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @PostMapping("user/signup")
    public String signup(@RequestBody SignupRequestDto requestdto) {

        userService.signup(requestdto);

        return "회원가입 완료";

    }

}