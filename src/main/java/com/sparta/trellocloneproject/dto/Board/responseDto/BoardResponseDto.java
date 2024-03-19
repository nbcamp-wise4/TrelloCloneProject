package com.sparta.trellocloneproject.dto.Board.responseDto;

import com.sparta.trellocloneproject.Entity.Board;
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
