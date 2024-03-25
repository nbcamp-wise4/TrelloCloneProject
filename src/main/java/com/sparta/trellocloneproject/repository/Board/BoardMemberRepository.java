package com.sparta.trellocloneproject.repository.board;

import com.sparta.trellocloneproject.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardMemberRepository extends JpaRepository<BoardMember, Long> {
    Optional<BoardMember> findBoardMemberByUserIDAndBoardID(Long userId, Long boardId);
    List<BoardMember> findBoardMemberByUserID(Long userId);
}