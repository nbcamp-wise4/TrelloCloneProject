package com.sparta.trellocloneproject.Controller;



import com.sparta.trellocloneproject.Service.UserService;
import com.sparta.trellocloneproject.dto.LoginRequestDto;
import com.sparta.trellocloneproject.dto.SignupRequestDto;

import com.sparta.trellocloneproject.Entity.User;
import com.sparta.trellocloneproject.Entity.UserRoleEnum;
import com.sparta.trellocloneproject.Repository.UserRepository;
import com.sparta.trellocloneproject.Security.UserDetailsImpl;
import com.sparta.trellocloneproject.Security.UserDetailsServiceImpl;
import com.sparta.trellocloneproject.JWT.JwtUtil;
import com.sparta.trellocloneproject.Service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    PasswordEncoder passwordEncoder;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("user/signup")
    public String signup(@RequestBody SignupRequestDto requestdto) {

        userService.signup(requestdto);
        return "회원가입 완료";

    }






}