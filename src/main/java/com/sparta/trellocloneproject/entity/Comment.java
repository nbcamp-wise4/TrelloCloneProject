package com.sparta.trellocloneproject.entity;

import com.sparta.trellocloneproject.dto.comment.CommentRequestDto;
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
@Table(name ="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String comment;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name ="card_id")
    private Card card;

    public Comment(CommentRequestDto requestDto,Card card,String name){
        this.comment = requestDto.getComment();
        this.card = card;
        this.name = name;
    }

}
