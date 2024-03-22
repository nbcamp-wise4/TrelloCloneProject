package com.sparta.trellocloneproject.dto.board.requestDto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardRequestDto {
    private String title;
    private String color;
    private String description;
}
