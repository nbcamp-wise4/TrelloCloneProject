package com.sparta.trellocloneproject.Service;

import com.sparta.trellocloneproject.Entity.Board;
import com.sparta.trellocloneproject.Entity.User;
import com.sparta.trellocloneproject.Repository.BoardRepository;
import com.sparta.trellocloneproject.dto.requestDto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board createBoard(BoardRequestDto requestDto, User user) {

        Board board = boardRepository.save(new Board(requestDto, user.getID()));

        return board;
    }
}
