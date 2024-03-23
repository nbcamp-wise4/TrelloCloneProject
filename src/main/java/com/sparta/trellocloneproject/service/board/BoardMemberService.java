package com.sparta.trellocloneproject.service.board;

import com.sparta.trellocloneproject.dto.board.requestDto.BoardMemberDeleteDto;
import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.UserRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardMemberService {

    private final BoardMemberRepository boardMemberRepository;
    private final UserRepository userRepository;

    public BoardMember addBoardMember(Long userId,Long boardId){
        BoardMember boardMember = new BoardMember(boardId,userId);

        return boardMemberRepository.save(boardMember);
    }

    public void deleteBoardMember(Long boardId, BoardMemberDeleteDto deleteDto) {
        // 요청한 사용자 정보 가져오기
        User findUser = userRepository.findByUsername(deleteDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Long deleteUserId = findUser.getID();

        BoardMember boardMember = boardMemberRepository.findBoardMemberByUserIDAndBoardID(deleteUserId, boardId)
                .orElseThrow(() -> new IllegalArgumentException("보드 멤버를 찾을 수 없습니다."));

        boardMemberRepository.delete(boardMember);
    }

   public boolean isUserMember(UserDetailsImpl userDetails,Long boardId){
        BoardMember checkMember=boardMemberRepository.findBoardMemberByUserIDAndBoardID(userDetails.getUser().getID(),boardId)
                .orElseThrow(()-> new NullPointerException(""));

        return checkMember != null;
    }
}
