package com.sparta.trellocloneproject.entity;

import com.sparta.trellocloneproject.dto.board.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateTitleDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="boards")
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String title;
    @Column
    private String color;
    @Column
    private String description;

    @OneToMany
    @JoinColumn(name = "board_id")
    private List<Columns> columns = new ArrayList<>();

    public Board(BoardRequestDto requestDto, User user) {
        this.title = requestDto.getTitle();
        this.color = requestDto.getColor();
        this.description = requestDto.getDescription();
        this.user = user;
    }

    public void updateBoardTitle(BoardUpdateTitleDto requestTitleDto) {
        this.title = requestTitleDto.getTitle();
    }

    public void updateBoardColor(BoardUpdateColorDto requestColorDto) {
        this.color = requestColorDto.getColor();
    }

    public void updateBoardDescription(BoardUpdateDescriptionDto requestDescriptionDto) {
        this.description = requestDescriptionDto.getDescription();
    }
}
