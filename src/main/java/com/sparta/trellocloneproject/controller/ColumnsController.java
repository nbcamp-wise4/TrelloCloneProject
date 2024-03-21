package com.sparta.trellocloneproject.controller;

import com.sparta.trellocloneproject.entity.BoardMember;
import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.repository.BoardRepository;
import com.sparta.trellocloneproject.repository.BoardMemberRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.service.ColumnsService;
import com.sparta.trellocloneproject.dto.ColumnsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ColumnsController {
    private final BoardRepository boardRepository;
    private final BoardMemberRepository boardmemberRepository;
    private final ColumnsService columnsService;

    @PostMapping("/{boardId}/columns")
    public String addColumn(@RequestBody ColumnsRequestDto requestDto,@PathVariable String boardId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Long bID = Long.parseLong(boardId);
        BoardMember member = boardmemberRepository.getReferenceById(bID);
        Long memberUserID = member.getUserID();
        User user = userDetails.getUser();
        if(!Objects.equals(memberUserID, user.getID())){
            throw new IllegalArgumentException("접근제한");
        }
        columnsService.createColumn(requestDto,boardRepository.getReferenceById(member.getBoardID()));
          return "ok";
    }

    @PutMapping("/{memberId}/{columnId}")
    public String titleUpdate(@RequestBody ColumnsRequestDto requestDto,@PathVariable String memberId,@PathVariable String columnId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Long mID = Long.parseLong(memberId);
        BoardMember member = boardmemberRepository.getReferenceById(mID);
        Long memberUserID = member.getUserID();
        User user = userDetails.getUser();
        if(!Objects.equals(memberUserID, user.getID())){
            throw new IllegalArgumentException("접근제한");
        }
        Long cID = Long.parseLong(columnId);
        columnsService.updateColumn(requestDto.getTitle(),cID);
        return "ok";
    }

    @DeleteMapping("/{memberId}/{columnId}")
    public String deleteColumn(@PathVariable String memberId,@PathVariable String columnId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Long mID = Long.parseLong(memberId);
        BoardMember member = boardmemberRepository.getReferenceById(mID);
        Long memberUserID = member.getUserID();
        User user = userDetails.getUser();
        if(!Objects.equals(memberUserID, user.getID())){
            throw new IllegalArgumentException("접근제한");
        }
        Long cID = Long.parseLong(columnId);
        columnsService.deleteColumn(cID);
        return "ok";
    }

    @GetMapping("/{memberId}")
    public List<Columns> getColumnList(@PathVariable String memberId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long mID = Long.parseLong(memberId);
        BoardMember member = boardmemberRepository.getReferenceById(mID);
        Long memberUserID = member.getUserID();
        User user = userDetails.getUser();
        if(!Objects.equals(memberUserID, user.getID())){
            throw new IllegalArgumentException("접근제한");
        }
        Long bID = member.getBoardID();
        return columnsService.getColumnsList(bID);

    }






}