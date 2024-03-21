package com.sparta.trellocloneproject.controller.comment;

import com.sparta.trellocloneproject.Service.comment.CommentService;
import com.sparta.trellocloneproject.dto.comment.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.UserSessionEvent;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequestDto dto, @LoginUser UserSessionEvent userSessionEvent) {
        return ResponseEntity.ok(commentService.commentSave(userSessionEvent.getName(), id, dto));
    }

    @PutMapping()
    public ResponseEntity<Long> update(@PathVariable Long postsId, @PathVariable Long id, @RequestBody CommentDto.Request dto) {
        commentService.update(postsId, id, dto);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping()
    public ResponseEntity<Long> delete(@PathVariable Long postId, @PathVariable Long id) {
        commentService.delete(postId, id);
        return ResponseEntity.ok(id);
    }
}
