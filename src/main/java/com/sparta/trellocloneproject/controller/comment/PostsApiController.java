package com.sparta.trellocloneproject.controller.comment;

import com.sparta.trellocloneproject.Service.comment.PostsService;
import com.sparta.trellocloneproject.dto.comment.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping
    public ResponseEntity save(@RequestBody PostsDto.Request dto,@LoginUser UserDto.Response user){
        return ResponseEntity.ok(postsService.save(dto,user.getName()));
    }

    @GetMapping
    public ResponseEntity read(@PathVariable Long id){
        return ResponseEntity.ok(postsService.findById(id));
    }

    @PutMapping
    public ResponseEntity update(@PathVariable Long id, @RequestBody PostsDto.Request dto){
        postsService.update(id,dto);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id){
        postsService.delete(id);
        return ResponseEntity.ok(id);
    }
}
