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
    private Long BoardID;
    @Column
    private Long UserID;

    public BoardMember(Long BoardID,Long UserID){
        this.BoardID = BoardID;
        this.UserID = UserID;


    }

}