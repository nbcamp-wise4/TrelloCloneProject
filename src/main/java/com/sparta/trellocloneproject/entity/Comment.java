package com.sparta.trellocloneproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 내용

    @Column(name = "create_date")
    @CreatedDate
    private String createDate;

    @Column(name = "modified_date")
    @CreatedDate
    private String modifiedDate;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts; // 해당 댓글이 속한 기능

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // 작성자

    public void update(String comment) {
        this.comment = comment;
    }
}
