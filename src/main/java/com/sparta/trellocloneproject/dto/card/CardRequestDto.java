package com.sparta.trellocloneproject.dto.card;


import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CardRequestDto {
    private String title;
    private String description;
    private String color;
    private String startDate;
    private String dueDate;

}