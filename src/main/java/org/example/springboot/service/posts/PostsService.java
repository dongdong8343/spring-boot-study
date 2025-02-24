package org.example.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public SavePost.Response save(SavePost.Request request) {
        Long postId = postsRepository.save(request.toEntity()).getId();

        return SavePost.Response.fromRequest(postId, request);
    }

    @Transactional
    public Long update(Long id, UpdatePost.Request request) {
        Post post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.update(request);
        return id;
    }

    @Transactional(readOnly = true)
    public SearchPost.Response findById(Long id) {
        Post entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return SearchPost.Response.fromEntity(entity);
    }

    @Transactional(readOnly = true)
    public List<ReadPosts.Response> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(ReadPosts.Response::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete(Long id){
        Post post = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(post);
    }
}
