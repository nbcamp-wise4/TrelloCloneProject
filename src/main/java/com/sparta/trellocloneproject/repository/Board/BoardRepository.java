package com.sparta.trellocloneproject.repository.Board;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
