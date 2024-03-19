package com.sparta.trellocloneproject.Controller;

import com.sparta.trellocloneproject.Entity.Board;
import com.sparta.trellocloneproject.Security.UserDetailsImpl;
import com.sparta.trellocloneproject.Service.BoardService;
import com.sparta.trellocloneproject.dto.requestDto.BoardRequestDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateColorDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateDescriptionDto;
import com.sparta.trellocloneproject.dto.requestDto.BoardUpdateTitleDto;
import com.sparta.trellocloneproject.dto.responseDto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<BoardResponseDto> createBoard(
            @RequestBody BoardRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        Board board = boardService.createBoard(requestDto, userDetails.getUser());
        BoardResponseDto responseDto = new BoardResponseDto(board);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

    }

    @GetMapping("")
    public ResponseEntity<BoardResponseDto> getAllBoards() {
        List<BoardResponseDto> responseDto = boardService.getAllBoards();

        return ResponseEntity.ok((BoardResponseDto) responseDto);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponseDto> getBoard() {

        return null;
    }

    @PutMapping("/{boardId}/name")
    public ResponseEntity<BoardResponseDto> updateBoardTitle(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateTitleDto requestTitle,
            @AuthenticationPrincipal UserDetails userDetails) {
        Board board = boardService.updateBoardTitle(boardId, requestTitle, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return ResponseEntity.ok(boardResponseDto);
    }

    @PutMapping("/{boardId}/color")
    public ResponseEntity<BoardResponseDto> updateBoardColor(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateColorDto requestColor,
            @AuthenticationPrincipal UserDetails userDetails) {
        Board board = boardService.updateBoardColor(boardId, requestColor, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return ResponseEntity.ok(boardResponseDto);
    }

    @PutMapping("/{boardId}/description")
    public ResponseEntity<BoardResponseDto> updateBoardDescription(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateDescriptionDto requestDescription,
            @AuthenticationPrincipal UserDetails userDetails) {
        Board board = boardService.updateBoardDescription(boardId, requestDescription, userDetails.getUser());
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return ResponseEntity.ok(boardResponseDto);
    }
}