package com.sparta.trellocloneproject.service.board;

import com.sparta.trellocloneproject.dto.board.requestDto.BoardMemberRequestDto;
import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.repository.Board.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.Board.BoardCustomRepository;
import com.sparta.trellocloneproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
@RequiredArgsConstructor
public class BoardMemberService {
    private final BoardMemberRepository boardMemberRepository;
    private final BoardCustomRepository boardCustomRepository;
    private final UserRepository userRepository;
    public BoardMember addBoardMember(BoardMemberRequestDto requestDto, User user) {
        // 요청한 사용자 정보 가져오기
        User findUser = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 보드 멤버 확인
        if (!user.equals(findUser)) {
            throw new IllegalArgumentException("보드멤버가 아닙니다");
        }

        // 보드 멤버 생성 및 저장
        Board findboard = boardCustomRepository.findById(requestDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("보드를 찾을 수 없습니다."));
        BoardMember boardMember = new BoardMember(findUser, findboard);
        boardMember = boardMemberRepository.save(boardMember);

        return boardMember;
    }


    public void deleteBoardMember(Long boardMemberId, User user) throws AccessDeniedException {
        // 요청한 사용자 정보 가져오기
        User findUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 보드 멤버 삭제 권한 확인
        BoardMember boardMember = boardMemberRepository.findById(boardMemberId)
                .orElseThrow(() -> new IllegalArgumentException("보드 멤버를 찾을 수 없습니다."));
        if (!boardMember.getUser().equals(findUser)) {
            throw new AccessDeniedException("보드 멤버 삭제 권한이 없습니다.");
        }

        // 보드 멤버 삭제
        boardMemberRepository.delete(boardMember);
    }
}
