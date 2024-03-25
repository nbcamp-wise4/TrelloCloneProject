package com.sparta.trellocloneproject.repository.repository;


import com.sparta.trellocloneproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
