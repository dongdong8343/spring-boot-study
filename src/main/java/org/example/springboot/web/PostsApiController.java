package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.SavePost;
import org.example.springboot.web.dto.SearchPost;
import org.example.springboot.web.dto.UpdatePost;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {
    private final PostsService postsService;

    @PatchMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody UpdatePost.Request updatePost) {
        return postsService.update(id, updatePost);
    }

    @PostMapping
    public SavePost.Response save(@RequestBody SavePost.Request request) {
        return postsService.save(request);
    }

    @GetMapping("/{id}")
    public SearchPost.Response findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
