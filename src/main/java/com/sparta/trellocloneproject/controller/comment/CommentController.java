package com.sparta.trellocloneproject.controller.comment;

import com.sparta.trellocloneproject.dto.comment.CommentRequestDto;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.service.comment.CommentService;
import com.sparta.trellocloneproject.service.board.BoardMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final BoardMemberService boardMemberService;
    @PostMapping("/{boardId}/{cardId}")
    public String createComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long cardId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)) {
            commentService.createComment(cardId, commentRequestDto, userDetails);
            return "ok";
        }
        throw new RuntimeException("");
    }

    @DeleteMapping("/{boardId}/{commentId}")
    public String deleteComment(@PathVariable Long commentId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)) {
            commentService.deleteComment(commentId);
            return "ok";
        }
        throw new RuntimeException("");
    }

}
