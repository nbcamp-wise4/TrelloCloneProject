package com.sparta.trellocloneproject.entity;

import com.sparta.trellocloneproject.dto.ColumnsRequestDto;
import jakarta.persistence.*;
import lombok.*;

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
    private int position;

    @ManyToOne
    @JoinColumn(name ="board_id")
    private Board board;

    public Columns (ColumnsRequestDto requestDto, Board board){
        this.title = requestDto.getTitle();
        this.board =board;
    }

    public void updateTitle(String title){
        this.title = title;
    }
}