package com.sparta.trellocloneproject.controller.board;

import com.sparta.trellocloneproject.dto.board.requestDto.BoardMemberRequestDto;
import com.sparta.trellocloneproject.dto.board.responseDto.BoardMemberResponseDto;
import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.service.board.BoardMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boardmembers")
public class BoardMemberController {

    private final BoardMemberService boardMemberService;

    @PostMapping("")
    public ResponseEntity<BoardMemberResponseDto> addBoardMember(
            @RequestBody BoardMemberRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        BoardMember boardMember = boardMemberService.addBoardMember(requestDto, userDetails.getUser());
        BoardMemberResponseDto responseDto = new BoardMemberResponseDto(boardMember);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @DeleteMapping("/{boardMemberId}")
    public ResponseEntity<String> deleteBoardMember(
            @PathVariable Long boardMemberId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) throws AccessDeniedException {

        boardMemberService.deleteBoardMember(boardMemberId, userDetails.getUser());

        return ResponseEntity.ok("보드 멤버 삭제 완료");
    }
}
