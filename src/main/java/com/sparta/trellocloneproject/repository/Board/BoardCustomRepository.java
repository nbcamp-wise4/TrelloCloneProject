package com.sparta.trellocloneproject.repository.Board;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardCustomRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByUser(User user);
}
