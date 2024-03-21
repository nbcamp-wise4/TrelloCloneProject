package com.sparta.trellocloneproject.service.comment;

import com.sparta.trellocloneproject.Entity.Posts;
import com.sparta.trellocloneproject.Entity.User;
import com.sparta.trellocloneproject.Repository.PostsRepository;
import com.sparta.trellocloneproject.Repository.UserRepository;
import com.sparta.trellocloneproject.dto.comment.PostsDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(PostsDto.Request dto, String name) {
        User user = userRepository.findByName(name);
        dto.setUser(user);
        Posts posts = dto.toEntity();
        postsRepository.save(posts);
        return posts.getId();
    }

    @Transactional(readOnly = true)
    public PostsDto.Response findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        return new PostsDto.Response(posts);
    }

    @Transactional
    public void update(Long id, PostsDto.Request dto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        posts.update(dto.getTitle(), dto.getContent());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        postsRepository.delete(posts);
    }
}
