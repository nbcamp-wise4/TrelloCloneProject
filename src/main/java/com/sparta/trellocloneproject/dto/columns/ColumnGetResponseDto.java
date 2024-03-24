package com.sparta.trellocloneproject.dto.columns;

import com.sparta.trellocloneproject.dto.card.CardResponseDto;
import com.sparta.trellocloneproject.entity.Columns;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ColumnGetResponseDto {
    private String title;
    private List<CardResponseDto> card;
    public ColumnGetResponseDto(Columns column, List<CardResponseDto> cardResponseDtoList) {
        this.title = column.getTitle();
        this.card = cardResponseDtoList;
    }
}
