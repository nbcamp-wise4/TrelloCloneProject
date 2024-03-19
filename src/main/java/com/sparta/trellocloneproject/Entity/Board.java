package com.sparta.trellocloneproject.Entity;

import com.sparta.trellocloneproject.dto.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateTitleDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="boards")
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long boardId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String title;
    @Column
    private String color;
    @Column
    private String description;

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
