package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.example.springboot.web.dto.SavePost;
import org.example.springboot.web.dto.SearchPost;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody SavePost.Request request) {
        return postsService.save(request);
    }

    @GetMapping("/api/v1/posts/{id}")
    public SearchPost.Response findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
