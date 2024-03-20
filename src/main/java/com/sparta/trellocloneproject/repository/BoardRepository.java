package com.sparta.trellocloneproject.repository;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByUser(User user);
}
