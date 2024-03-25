package com.sparta.trellocloneproject.repository.column;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.Columns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnsRepository extends JpaRepository<Columns, Long> {
    List<Columns> findColumnsByBoard(Board board);
    Columns findColumnsByPosition(Long position);
    List<Columns> findColumnsByBoardID(Long boardId);
}