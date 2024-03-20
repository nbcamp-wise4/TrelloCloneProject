package com.sparta.trellocloneproject.dto.board.responseDto;

import com.sparta.trellocloneproject.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class BoardResponseDto {
    private String title;

    public BoardResponseDto(Board board) {
        this.title = board.getTitle();
    }
}
