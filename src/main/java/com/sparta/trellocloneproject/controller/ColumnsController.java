package com.sparta.trellocloneproject.controller;

import com.sparta.trellocloneproject.dto.columns.ColumnsPositionRequestDto;
import com.sparta.trellocloneproject.dto.columns.ColumnsResponseDto;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.service.ColumnsService;
import com.sparta.trellocloneproject.dto.columns.ColumnsRequestDto;
import com.sparta.trellocloneproject.service.board.BoardMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ColumnsController {
    private final BoardRepository boardRepository;
    private final BoardMemberRepository boardmemberRepository;
    private final ColumnsService columnsService;
    private final BoardMemberService boardMemberService;

    @PostMapping("/{boardId}/columns")
    public String addColumn(@RequestBody ColumnsRequestDto requestDto,@PathVariable Long boardId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            columnsService.createColumn(requestDto,boardRepository.getReferenceById(boardId));
            return "ok";
        }
          return null;
    }

    @PutMapping("/{boardId}/{columnId}")
    public String titleUpdate(@RequestBody ColumnsRequestDto requestDto,@PathVariable Long boardId,@PathVariable Long columnId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            columnsService.updateColumn(requestDto.getTitle(),columnId);
            return "ok";
        }
        return null;

    }

    @DeleteMapping("/{boardId}/{columnId}")
    public String deleteColumn(@PathVariable Long boardId,@PathVariable Long columnId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            columnsService.deleteColumn(columnId);
            return "ok";
        }
        return null;
    }

    @GetMapping("/{boardId}/columns")
    public ResponseEntity<List<ColumnsResponseDto>> getColumnList(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            List<ColumnsResponseDto>  ColumnsList = columnsService.getColumnsList(boardId);
            return new ResponseEntity<>(ColumnsList, HttpStatus.OK);
        }
        return null;

    }
    @PutMapping("/{boardId}/columns/position")
    public String changePosition(@PathVariable Long boardId,@RequestBody ColumnsPositionRequestDto requestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
           columnsService.changePosition(requestDto.getPosition1(), requestDto.getPosition2());
           return "ok";
        }
        return null;

    }

}