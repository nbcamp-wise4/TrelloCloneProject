package com.sparta.trellocloneproject.service.column;

import com.sparta.trellocloneproject.dto.columns.ColumnsResponseDto;
import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.repository.ColumnsRepository;
import com.sparta.trellocloneproject.dto.columns.ColumnsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColumnsService {

    private final ColumnsRepository columnsRepository;
    private final BoardRepository boardRepository;

    public Columns createColumn(ColumnsRequestDto requestDto, Board currentBoard){
        long LastPositionOfColumn = Integer.toUnsignedLong(columnsRepository.findColumnsByBoard(currentBoard).size());
        Columns column = new Columns(requestDto,currentBoard,LastPositionOfColumn+1);
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

    public void changePosition(Long position1,Long position2){
        Columns column1 = columnsRepository.findColumnsByPosition(position1);
        Columns column2 = columnsRepository.findColumnsByPosition(position2);
        column1.updatePosition(position2);
        column2.updatePosition(position1);
        columnsRepository.save(column1);
        columnsRepository.save(column2);

    }
    public List<ColumnsResponseDto> getColumnsList(Long BoardId){
        List<Columns> ColumnsList = columnsRepository.findColumnsByBoard(boardRepository.getReferenceById(BoardId));
        return ColumnsList.stream().map(ColumnsResponseDto::new).toList();
    }


}