package com.sparta.trellocloneproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="boardmembers")
public class BoardMember extends Timestamped{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
    private Board board;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public BoardMember(User user, Board board) {
        this.user = user;
        this.board = board;
    }
}
