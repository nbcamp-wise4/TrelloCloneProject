package com.sparta.trellocloneproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="boardmember")
public class BoardMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column
    private Long boardID;
    @Column
    private Long userID;

    public BoardMember(Long BoardID,Long UserID){
        this.boardID = BoardID;
        this.userID = UserID;
    }
}