package com.sparta.trellocloneproject.service;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.repository.ColumnsRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.dto.ColumnsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColumnsService {

    private final ColumnsRepository columnsRepository;
    private final BoardRepository boardRepository;

    public Columns createColumn(ColumnsRequestDto requestDto, Board currentBoard){
        Columns column = new Columns(requestDto,currentBoard);
        return columnsRepository.save(column);
    }

    public Columns updateColumn(String newTitle,Long ID){
        Columns column = columnsRepository.findById(ID).orElseThrow(()-> new IllegalArgumentException("해당 컬럼이 존재하지 않습니다"));
        column.updateTitle(newTitle);
        return columnsRepository.save(column);
    }

    public void deleteColumn(Long ID){
        columnsRepository.deleteById(ID);
    }
    public List<Columns> getColumnsList(Long ID){
        Board board = boardRepository.findById(ID).orElseThrow(()-> new IllegalArgumentException("해당 컬럼이 존재하지 않습니다"));
        return board.getColumns();

    }

}