package org.example.springboot.provider;


import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.ReadPosts;
import org.example.springboot.web.dto.SavePost;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostProvider {
    private final PostsRepository postsRepository;

    public SavePost.Response save(SavePost.Request request) {
        Long postId = postsRepository.save(request.toEntity()).getId();

        return SavePost.Response.fromRequest(postId, request);
    }

    public Post searchPost(Long id) {
        return postsRepository.findByIdAndIsDeletedIsNull(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
    }

    public List<ReadPosts.Response> searchPosts() {
        return ReadPosts.Response.toResponse(postsRepository.findByIsDeletedIsNull());
    }

    @Transactional
    public void delete(Long id) {
        Post post = searchPost(id);
        post.delete();
    }
}
