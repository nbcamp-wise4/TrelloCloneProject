package com.sparta.trellocloneproject.entity;

import com.sparta.trellocloneproject.dto.columns.ColumnsRequestDto;
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
@Table(name ="columns")
public class Columns {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String title;
    @Column
    private Long position;

    @ManyToOne
    @JoinColumn(name ="board_id")
    private Board board;

    @OneToMany
    @JoinColumn(name = "columns_id")
    private List<Card> cards = new ArrayList<>();

    public Columns (ColumnsRequestDto requestDto,Board board,Long position){
        this.title = requestDto.getTitle();
        this.position = position;
        this.board =board;
    }

    public void updateTitle(String title){
        this.title = title;
    }
    public void updatePosition(Long position){
        this.position = position;
    }
}