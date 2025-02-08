package org.example.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostResponseDto findById(Long id) {
        Post entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return PostResponseDto.fromEntity(entity);
    }
}
