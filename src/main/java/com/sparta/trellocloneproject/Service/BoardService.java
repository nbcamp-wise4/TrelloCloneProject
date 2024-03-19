package com.sparta.trellocloneproject.Service;

import com.sparta.trellocloneproject.Entity.Board;
import com.sparta.trellocloneproject.Entity.User;
import com.sparta.trellocloneproject.Repository.BoardRepository;
import com.sparta.trellocloneproject.dto.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateTitleDto;
import com.sparta.trellocloneproject.dto.responseDto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Board updateBoardTitle(Long boardId, BoardUpdateTitleDto requestTitle, User user) {
        Board board = findOne(boardId);
        if(board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 수정할 수 있습니다.");
        }
        board.updateBoardTitle(requestTitle);
        return board;
    }

    @Transactional
    public Board updateBoardColor(Long boardId, BoardUpdateColorDto requestColor, User user) {
        Board board = findOne(boardId);
        if(board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 수정할 수 있습니다.");
        }
        board.updateBoardColor(requestColor);
        return board;
    }

    @Transactional
    public Board updateBoardDescription(Long boardId, BoardUpdateDescriptionDto requestDescription, User user) {
        Board board = findOne(boardId);
        if(board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 수정할 수 있습니다.");
        }
        board.updateBoardDescription(requestDescription);
        return board;
    }

    private Board findOne(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("없는 게시글 입니다."));
    }
}
