package org.example.springboot.web;

import org.example.springboot.domain.posts.Post;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.web.dto.PostsUpdateRequestDto;
import org.example.springboot.web.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void Posts_수정된다() throws Exception {
        // given
        Post savedPost = postsRepository.save(Post.ofPosts("title", "content", "author"));

        Long updateId = savedPost.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";
        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.ofPostsUpdateRequestDTO(expectedTitle, expectedContent);

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
    }
}
