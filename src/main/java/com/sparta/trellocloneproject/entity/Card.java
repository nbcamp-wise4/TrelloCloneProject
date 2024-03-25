package com.sparta.trellocloneproject.entity;

import com.sparta.trellocloneproject.dto.card.requestDto.CardRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="card")
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String color;
    @Column
    private String startDate;
    @Column
    private String dueDate;
    @ManyToOne
    @JoinColumn(name ="columns_id")
    private Columns columns;
    @OneToMany
    @JoinColumn(name = "card_id")
    private List<Comment> comments = new ArrayList<>();

    public Card(CardRequestDto requestDto,Columns column){
        this.title = requestDto.getTitle();
        this.description = requestDto.getDescription();
        this.color = requestDto.getColor();
        this.startDate = requestDto.getStartDate();
        this.dueDate = requestDto.getDueDate();
        this.columns = column;
    }

    public void updateTitle(String title){
        this.title = title;
    }

    public void updateDescription(String description){
        this.description = description;
    }

    public void updateColor(String color){
        this.color = color;
    }

    public void updateStartDate(String startDate){
        this.startDate = startDate;
    }

    public void updateDueDate(String dueDate){
        this.dueDate = dueDate;
    }

}