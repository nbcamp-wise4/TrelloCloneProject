package com.sparta.trellocloneproject.repository;

import com.sparta.trellocloneproject.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Comment, Long> {
}
