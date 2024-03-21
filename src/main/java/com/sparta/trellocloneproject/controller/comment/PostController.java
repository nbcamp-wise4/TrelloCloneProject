package com.sparta.trellocloneproject.controller.comment;

import com.sparta.trellocloneproject.Service.comment.PostsService;
import com.sparta.trellocloneproject.dto.comment.CommentResponseDto;
import com.sparta.trellocloneproject.dto.comment.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostsService postsService;

    // 글 상세보기
    @GetMapping("")
    public String read(@PathVariable Long id, @LoginUser UserSessionDto user, Model model) {
        PostResponseDto dto = postsService.findById(id);
        List<CommentResponseDto> comments = dto.getComments();

        // 댓글 List
        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }

        // 사용자 관련
        if (user != null) {
            model.addAttribute("user", user.getName());

            // 게시글 작성자 본인확인
            if (dto.getUserId().equals(user.getId())) {
                model.addAttribute("writer", true);
            }

            for (int i = 0; i < comments.size(); i++) {
                boolean isWriter = comments.get(i).getId().equals(user.getId());
                log.info("작성자 확인 : " + isWriter);
                model.addAttribute("작성자 확인 : ", isWriter);
            }
        }

        postsService.updateView(id);
        model.addAttribute("posts",dto);
        return "posts/posts-read";

        postsService.updateView(id);
        model.addAttribute("posts", dto);
        return "posts/posts-read";
    }

}
