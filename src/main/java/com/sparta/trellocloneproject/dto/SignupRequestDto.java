package com.sparta.trellocloneproject.dto;





import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String password;
    private String name;
    private String authorityToken;

}
