package com.sparta.trellocloneproject.dto.card.responseDto;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Data
public class CardResponseDto {
    private String title;


    public CardResponseDto(Card card) {
        this.title = card.getTitle();
    }
}
