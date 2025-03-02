package org.example.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    private String author;

    private LocalDateTime isDeleted;

    private Post(String title, String content, String author, LocalDateTime isDeleted) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.isDeleted = isDeleted;
    }

    // 정적 팩토리 메서드
    public static Post ofPosts(String title, String content, String author) {
        return new Post(title, content, author, null);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void delete(){
        this.isDeleted = LocalDateTime.now();
    }
}
