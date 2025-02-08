package org.example.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.web.dto.PostsUpdateRequestDto;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 정적 팩토리 메서드
    public static Post ofPosts(String title, String content, String author) {
        return new Post(title, content, author);
    }

    public void update(PostsUpdateRequestDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}
