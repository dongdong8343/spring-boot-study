package org.example.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.provider.PostProvider;
import org.example.springboot.web.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostProvider postProvider;

    public SavePost.Response save(SavePost.Request request) {
        Post post = postProvider.save(request.toEntity());

        return SavePost.Response.toResponse(post);
    }

    public Long update(Long id, UpdatePost.Request request) {
        Post post = postProvider.searchPost(id);
        post.update(request.getTitle(), request.getContent());
        return id;
    }

    public SearchPost.Response findById(Long id) {
        Post entity = postProvider.searchPost(id);

        return SearchPost.Response.fromEntity(entity);
    }

    public List<ReadPosts.Response> findAllDesc() {
        return ReadPosts.Response.toResponse(postProvider.searchPosts());
    }

    public void delete(Long id){
        postProvider.delete(id);
    }
}
