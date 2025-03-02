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

    @Transactional
    public SavePost.Response save(SavePost.Request request) {
        return postProvider.save(request);
    }

    @Transactional
    public Long update(Long id, UpdatePost.Request request) {
        Post post = postProvider.searchPost(id);
        post.update(request.getTitle(), request.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public SearchPost.Response findById(Long id) {
        Post entity = postProvider.searchPost(id);

        return SearchPost.Response.fromEntity(entity);
    }

    @Transactional(readOnly = true)
    public List<ReadPosts.Response> findAllDesc() {
        return postProvider.searchPosts();
    }


    @Transactional
    public void delete(Long id){
        postProvider.delete(id);
    }
}
