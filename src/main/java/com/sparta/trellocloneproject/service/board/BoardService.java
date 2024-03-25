package com.sparta.trellocloneproject.service.board;

import com.sparta.trellocloneproject.dto.board.responseDto.BoardGetResponseDto;
import com.sparta.trellocloneproject.dto.card.responseDto.CardResponseDto;
import com.sparta.trellocloneproject.dto.columns.responseDto.ColumnGetResponseDto;
import com.sparta.trellocloneproject.entity.*;
import com.sparta.trellocloneproject.repository.Board.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.Board.BoardRepository;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateTitleDto;
import com.sparta.trellocloneproject.dto.board.responseDto.BoardResponseDto;
import com.sparta.trellocloneproject.repository.column.ColumnsRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMemberRepository boardMemberRepository;
    private final ColumnsRepository columnsRepository;

    public Board createBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails) {
        Board board = boardRepository.save(new Board(requestDto, userDetails.getUser()));
        BoardMember boardMember = new BoardMember(board.getID(),userDetails.getUser().getID());
        boardMemberRepository.save(boardMember);

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

    // 보드 단일 조회 기능 추가
    public BoardGetResponseDto getBoard(Long boardId, User user) {
        Board board = findOne(boardId);

        // 보드에 속한 모든 컬럼과 카드 가져오기
        List<Columns> columnsList = columnsRepository.findColumnsByBoardID(boardId);
        List<ColumnGetResponseDto> columnsGetResponseDtoList = new ArrayList<>();
        for (Columns column : columnsList) {
            List<Card> cards = column.getCards();
            List<CardResponseDto> cardResponseDtoList = cards.stream()
                    .map(CardResponseDto::new)
                    .collect(Collectors.toList());
            columnsGetResponseDtoList.add(new ColumnGetResponseDto(column, cardResponseDtoList));
        }

        return new BoardGetResponseDto(board, columnsGetResponseDtoList);
    }

    @Transactional
    public Board updateBoardTitle(Long boardId, BoardUpdateTitleDto requestTitle, User user) {
        Board board = findOne(boardId);

        board.updateBoardTitle(requestTitle);
        return board;
    }

    @Transactional
    public Board updateBoardColor(Long boardId, BoardUpdateColorDto requestColor, User user) {
        Board board = findOne(boardId);

        board.updateBoardColor(requestColor);
        return board;
    }

    @Transactional
    public Board updateBoardDescription(Long boardId, BoardUpdateDescriptionDto requestDescription, User user) {
        Board board = findOne(boardId);

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
