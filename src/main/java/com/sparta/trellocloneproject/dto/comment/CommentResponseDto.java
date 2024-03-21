package com.sparta.trellocloneproject.dto.comment;

import com.sparta.trellocloneproject.Entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {
    private Long id;
    private String comment;
    private String createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String name;
    private Long postsId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.createDate = comment.getCreateDate();
        this.modifiedDate = comment.getModifiedDate();
        this.name = comment.getUser().getName();
        this.postsId = comment.getPosts().getId();
    }
}
