package com.sparta.trellocloneproject.dto.board.responseDto;

import com.sparta.trellocloneproject.dto.columns.responseDto.ColumnGetResponseDto;
import com.sparta.trellocloneproject.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class BoardGetResponseDto {
    private String title;
    private List<ColumnGetResponseDto> columns;

    public BoardGetResponseDto(Board board, List<ColumnGetResponseDto> columnsGetResponseDtoList) {
        this.title = board.getTitle();
        this.columns = columnsGetResponseDtoList;
    }
}
