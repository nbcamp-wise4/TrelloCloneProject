package com.sparta.trellocloneproject.service.comment;

import com.sparta.trellocloneproject.entity.Comment;
import com.sparta.trellocloneproject.entity.Posts;
import com.sparta.trellocloneproject.entity.User;
import com.sparta.trellocloneproject.repository.CommentRepository;
import com.sparta.trellocloneproject.repository.PostsRepository;
import com.sparta.trellocloneproject.repository.UserRepository;
import com.sparta.trellocloneproject.dto.comment.CommentRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostsRepository postRepository;

    @Transactional
    public Long commentSave(String name, Long id, CommentRequestDto dto) {
        User user = userRepository.findByName(name);
        Posts posts = postRepository.findById(id).orElseThrow() ->
        new IllegalArgumentException("[댓글 작성 실패] 해당 게시글이 존재하지 않습니다." + id);

        dto.setUser(user);
        dto.setPosts(posts);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }

    @Transactional
    public void update(Long postId, Long id, CommentDto.Request dto) {
        Comment comment = commentRepository.findByPostsIdAndId(postId, id).orElseThrow() ->
        new IllegalArgumentException("해당 댓글이 존재하지 않습니다." + id);
        comment.update(dto.getComment());
    }

    @Transactional
    public void delete(Long postId, Long id) {
        Comment comment = commentRepository.findByPostIdAndId(postId, id).orElseThrow() ->
        new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id = " + id);
        commentRepository.delete(comment);
    }

}
