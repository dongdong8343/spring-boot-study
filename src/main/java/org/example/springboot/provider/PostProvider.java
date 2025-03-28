package org.example.springboot.provider;


import lombok.RequiredArgsConstructor;
import org.example.springboot.config.error.exception.PostNotFoundException;
import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostProvider {
    private final PostsRepository postsRepository;

    @Transactional
    public Post save(Post post) {
        return postsRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Post searchPost(Long id) {
        return postsRepository.findByIdAndIsDeletedIsNull(id).orElseThrow(PostNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<Post> searchPosts() {
        return postsRepository.findByIsDeletedIsNull();
    }

    @Transactional
    public void delete(Long id) {
        Post post = postsRepository.findByIdAndIsDeletedIsNull(id).orElseThrow(PostNotFoundException::new);

        post.delete();
    }
}
