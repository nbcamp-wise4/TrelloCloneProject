package com.sparta.trellocloneproject.dto.board.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardMemberRequestDto {
    private String username;
    private Long boardId;
}
