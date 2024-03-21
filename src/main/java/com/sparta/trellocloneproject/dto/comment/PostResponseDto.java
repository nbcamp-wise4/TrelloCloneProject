package com.sparta.trellocloneproject.dto.comment;

import com.sparta.trellocloneproject.Entity.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private int view;
    private Long userId;
    private List<CommentResponseDto> comments;

    public PostResponseDto(Posts posts){
        this.id= posts.getId();
        this.title= posts.getTitle();
        this.writer= posts.getWriter();
        this.content= posts.getContent();
        this.createDate=posts.getCreateDate();
        this.modifiedDate = posts.getModifiedDate();
        this.view = posts.getView();
        this.userId = posts.getUser().getId();
        this.comments = posts.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }

}
