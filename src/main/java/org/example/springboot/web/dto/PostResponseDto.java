package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.posts.Post;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    private PostResponseDto(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static PostResponseDto fromEntity(Post entity){
        return new PostResponseDto(entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor());
    }
}
