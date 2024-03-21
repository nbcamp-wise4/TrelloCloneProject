package com.sparta.trellocloneproject.repository;

import com.sparta.trellocloneproject.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardMemberRepository extends JpaRepository<BoardMember,Long> {

}