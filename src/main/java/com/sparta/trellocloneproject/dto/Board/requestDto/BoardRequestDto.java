package com.sparta.trellocloneproject.dto.Board.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto {
    private String title;
    private String color;
    private String description;
}