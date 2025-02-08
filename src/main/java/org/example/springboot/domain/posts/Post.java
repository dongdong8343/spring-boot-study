package org.example.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 정적 팩토리 메서드
    public static Posts ofPosts(String title, String content, String author) {
        return new Posts(title, content, author);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
