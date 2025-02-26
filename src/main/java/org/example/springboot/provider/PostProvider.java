package org.example.springboot.provider;


import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.ReadPosts;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostProvider {
    private final PostsRepository postsRepository;

    public Post searchPost(Long id) {
        return postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
    }

    public List<ReadPosts.Response> searchPosts() {
        return postsRepository.findAllDesc().stream()
                .map(ReadPosts.Response::new)
                .collect(Collectors.toList());
    }
}
