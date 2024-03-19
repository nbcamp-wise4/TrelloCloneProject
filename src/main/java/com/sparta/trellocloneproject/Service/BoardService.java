package com.sparta.trellocloneproject.Service;

import com.sparta.trellocloneproject.Entity.Board;
import com.sparta.trellocloneproject.Entity.User;
import com.sparta.trellocloneproject.Repository.BoardRepository;
import com.sparta.trellocloneproject.dto.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.responseDto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(BoardRequestDto requestDto, User user) {

        Board board = boardRepository.save(new Board(requestDto, user.getID()));

        return board;
    }

    public List<BoardResponseDto> getAllBoards() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();

        // 보드 이름
        for(Board board : boardList) {
            boardResponseDtoList.add(new BoardResponseDto(board));
        }
        return boardResponseDtoList;
    }

    public List<BoardResponseDto> getBoard() {
        // 해당 보드 조회 (컬럼과 카드)?
        return null;
    }
}
