package com.sparta.trellocloneproject.service.board;

import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BoardMemberService {

    private final BoardMemberRepository boardMemberRepository;



    public BoardMemberService(BoardMemberRepository boardMemberRepository) {
        this.boardMemberRepository = boardMemberRepository;
    }

    public void addBoardCreatorToMember(Board board, UserDetailsImpl userDetails){
        BoardMember boardMember = new BoardMember(board.getID(),userDetails.getUser().getID());
        boardMemberRepository.save(boardMember);

    }

    public BoardMember addBoardMember(Long UserId,Long BoardId){
        BoardMember boardMember = new BoardMember(BoardId,UserId);
        return boardMemberRepository.save(boardMember);

    }


   public boolean isUserMember(UserDetailsImpl userDetails,Long boardId){
        BoardMember checkMember=boardMemberRepository.findBoardMemberByUserIDAndBoardID(userDetails.getUser().getID(),boardId)
                .orElseThrow(()-> new NullPointerException(""));

        return checkMember != null;

    }

}
