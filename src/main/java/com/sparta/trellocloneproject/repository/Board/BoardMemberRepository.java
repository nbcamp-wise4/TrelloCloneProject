package com.sparta.trellocloneproject.repository.Board;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoardMemberRepository extends JpaRepository<BoardMember, Long> {
    boolean existsByBoardAndUser(Board board, User findUser);
}
