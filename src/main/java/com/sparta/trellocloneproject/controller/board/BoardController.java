package com.sparta.trellocloneproject.controller.board;

import com.sparta.trellocloneproject.dto.board.BoardMemberRequestDto;
import com.sparta.trellocloneproject.entity.Board;
import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.service.board.BoardMemberService;
import com.sparta.trellocloneproject.service.board.BoardService;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.board.requestDto.BoardUpdateTitleDto;
import com.sparta.trellocloneproject.dto.board.responseDto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardMemberRepository boardMemberRepository;
    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final BoardMemberService boardMemberService;




    @PostMapping("")
    public ResponseEntity<BoardResponseDto> createBoard(
            @RequestBody BoardRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {

        Board board = boardService.createBoard(requestDto, userDetails.getUser());
        boardMemberService.addBoardCreatorToMember(board,userDetails);
        BoardResponseDto responseDto = new BoardResponseDto(board);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("")
    public List<BoardResponseDto> getUserAllBoards(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        return boardService.getUserAllBoards(userDetails);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> getBoard(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        return null;
    }

    @PutMapping("/{boardId}/name")
    public ResponseEntity<BoardResponseDto> updateBoardTitle(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateTitleDto requestTitle,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(boardMemberService.isUserMember(userDetails,boardId)){
        Board board = boardService.updateBoardTitle(boardId, requestTitle, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return ResponseEntity.ok(boardResponseDto);}
        return null;
    }

    @PutMapping("/{boardId}/color")
    public ResponseEntity<BoardResponseDto> updateBoardColor(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateColorDto requestColor,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(boardMemberService.isUserMember(userDetails,boardId)){
        Board board = boardService.updateBoardColor(boardId, requestColor, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return ResponseEntity.ok(boardResponseDto);}
        return null;
    }

    @PutMapping("/{boardId}/description")
    public ResponseEntity<BoardResponseDto> updateBoardDescription(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateDescriptionDto requestDescription,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(boardMemberService.isUserMember(userDetails,boardId)){
        Board board = boardService.updateBoardDescription(boardId, requestDescription, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return ResponseEntity.ok(boardResponseDto);}
        return null;
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(
            @PathVariable Long boardId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(boardMemberService.isUserMember(userDetails,boardId)){
        boardService.deleteBoard(boardId, userDetails.getUser());

        return ResponseEntity.ok("보드 삭제 완료");}
        return null;
    }

    @PostMapping("/{boardId}/member")
    public String addmember(@RequestBody BoardMemberRequestDto requestDto, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
        Long UId = requestDto.getUserId();
        boardMemberService.addBoardMember(UId, boardId);
        return "ok";}
        return null;
    }
}