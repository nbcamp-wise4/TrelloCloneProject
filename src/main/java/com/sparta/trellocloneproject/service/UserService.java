package com.sparta.trellocloneproject.service;



import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.dto.SignupRequestDto;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.entity.UserRoleEnum;
import com.sparta.trellocloneproject.repository.UserRepository;
import com.sparta.trellocloneproject.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Objects;
import java.util.Optional;

@Service

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    String ADMIN_TOKEN = "2";

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String name = requestDto.getName();
        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        UserRoleEnum role = UserRoleEnum.USER;


        if (ADMIN_TOKEN.equals(requestDto.getAuthorityToken())) {

            role = UserRoleEnum.ADMIN;
        }



        User user = new User(username,password,role,name);
        userRepository.save(user);
    }




    public void deleteUser(Long userId, UserDetailsImpl userDetails) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("해당 Id를 가진 유저는 존재하지 않습니다.")
        );
        if(Objects.equals(userDetails.getAuthorities().toString(), "[ADMIN]")){
            throw new IllegalArgumentException("admin 권한의 유저를 삭제할 순 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}