package com.sparta.trellocloneproject.repository;

import com.sparta.trellocloneproject.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardMemberRepository extends JpaRepository<BoardMember, Long> {
    Optional<BoardMember> findBoardMemberByUserIDAndBoardID(Long UserId, Long BoardId);
}
