package com.sparta.trellocloneproject.service.board;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateTitleDto;
import com.sparta.trellocloneproject.dto.board.responseDto.BoardResponseDto;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.repository.ColumnsRepository;
import com.sparta.trellocloneproject.repository.UserRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final BoardMemberRepository boardMemberRepository;
    private final ColumnsRepository columnsRepository;

    public Board createBoard(BoardRequestDto requestDto, User user) {
        Board board = boardRepository.save(new Board(requestDto, user));

        return board;
    }

    public List<BoardResponseDto> getUserAllBoards(Long userId) {
        List<BoardMember> userMembershipList = boardMemberRepository.findBoardMemberByUserID(userId);
        List<Board> boardList = new ArrayList<>();

        for(BoardMember boardMember : userMembershipList) {
            Board board = boardRepository.findById(boardMember.getBoardID())
                    .orElseThrow(()->new IllegalArgumentException("보드를 찾을 수 없습니다."));
            boardList.add(board);
        }
        return boardList.stream().map(BoardResponseDto::new).toList();
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
