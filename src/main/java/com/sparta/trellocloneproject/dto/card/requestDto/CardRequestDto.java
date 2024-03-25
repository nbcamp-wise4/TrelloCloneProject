package com.sparta.trellocloneproject.dto.card.requestDto;

import lombok.Getter;

@Getter
public class CardRequestDto {
    private String title;
    private String description;
    private String color;
    private String startDate;
    private String dueDate;

}