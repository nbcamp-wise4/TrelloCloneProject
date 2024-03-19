package com.sparta.trellocloneproject.Repository;

import com.sparta.trellocloneproject.Entity.Board;
import com.sparta.trellocloneproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
