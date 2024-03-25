package com.sparta.trellocloneproject.repository.board;

import com.sparta.trellocloneproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
