package com.sparta.trellocloneproject.repository;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ColumnsRepository extends JpaRepository<Columns, Long> {
List<Columns> findColumnsByBoard(Board board);
Columns findColumnsByPosition(Long position);




}