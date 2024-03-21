package com.sparta.trellocloneproject.dto.comment;

import com.sparta.trellocloneproject.Entity.Posts;
import com.sparta.trellocloneproject.Entity.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class PostsDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private Long id;
        private String title;
        private String writer;
        private String content;
        private String createDate;
        private String modifiedDate;
        private int view;
        private User user;

        public Posts toEntity() {
            Posts posts = Posts.builder().id(id).title(title).writer(writer).content(content).view(0).user(user).build();

            return posts;
        }
    }

    @Getter
    public static class Response{
        private Long id;
        private String title;
        private String writer;
        private String content;
        private String createDate;
        private String modifiedDate;
        private int view;
        private User userId;
        private List<CommentDto.Response> comments;

        public Response(Posts posts){
            this.id= posts.getId();
            this.title= posts.getTitle();
            this.writer= posts.getWriter();
            this.content= posts.getContent();
            this.createDate=posts.getCreateDate();
            this.modifiedDate=posts.getModifiedDate();
            this.view= posts.getView();
            this.userId=posts.getUser().getId();
            this.comments=posts.getComments().stream().map(CommentDto.Response::new).collect(Collectors.toList());
        }
    }
}
