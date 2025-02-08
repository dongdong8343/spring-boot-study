package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    private PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static PostsUpdateRequestDto ofPostsUpdateRequestDTO(String title, String content) {
        return new PostsUpdateRequestDto(title, content);
    }
}
