package com.sparta.trellocloneproject.service.board;

import com.sparta.trellocloneproject.entity.Board;
//import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateTitleDto;
import com.sparta.trellocloneproject.dto.board.responseDto.BoardResponseDto;
import com.sparta.trellocloneproject.repository.UserRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public Board createBoard(BoardRequestDto requestDto, User user) {
        Board board = boardRepository.save(new Board(requestDto, user));

        return board;
    }

    public List<BoardResponseDto> getUserAllBoards(UserDetailsImpl userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("존재하는 회원이 없습니다."));
        return boardRepository.findAllByUser(user)
                .stream().map(BoardResponseDto::new).toList();
    }

    public List<BoardResponseDto> getBoard() {
        // 해당 보드 조회 (컬럼과 카드)?
        return null;
    }

    @Transactional
    public Board updateBoardTitle(Long boardId, BoardUpdateTitleDto requestTitle, User user) {
        Board board = findOne(boardId);
        if(!board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 수정할 수 있습니다.");
        }
        board.updateBoardTitle(requestTitle);
        return board;
    }

    @Transactional
    public Board updateBoardColor(Long boardId, BoardUpdateColorDto requestColor, User user) {
        Board board = findOne(boardId);

        if(!board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 수정할 수 있습니다.");
        }
        board.updateBoardColor(requestColor);
        return board;
    }

    @Transactional
    public Board updateBoardDescription(Long boardId, BoardUpdateDescriptionDto requestDescription, User user) {
        Board board = findOne(boardId);
        if(!board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 수정할 수 있습니다.");
        }
        board.updateBoardDescription(requestDescription);
        return board;
    }

    private Board findOne(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("없는 게시글 입니다."));
    }

    public void deleteBoard(Long boardId, User user) {
        Board board = findOne(boardId);

        if(!board.getUser().equals(user)) {
            throw new IllegalArgumentException("생성자만 삭제할 수 있습니다.");
        }
        boardRepository.delete(board);
    }
}
