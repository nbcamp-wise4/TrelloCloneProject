package com.sparta.trellocloneproject.dto.comment;

import com.sparta.trellocloneproject.Entity.Comment;
import com.sparta.trellocloneproject.Entity.Posts;
import com.sparta.trellocloneproject.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {
    private Long id;
    private String commnet;
    private String createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy,MM,dd HH:mm"));
    private User user;
    private Posts posts;

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(commnet)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .user(user)
                .posts(posts)
                .build();

        return comments;
    }
}
