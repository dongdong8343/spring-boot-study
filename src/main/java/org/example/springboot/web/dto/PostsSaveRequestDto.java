package org.example.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Post;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    private PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static PostsSaveRequestDto saveRequest(String title, String content, String author) {
        return new PostsSaveRequestDto(title, content, author);
    }

    public Post toEntity() {
        return Post.ofPosts(this.title, this.content, this.author);
    }
}
