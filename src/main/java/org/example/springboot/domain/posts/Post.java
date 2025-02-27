package org.example.springboot.domain.posts;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.web.dto.UpdatePost;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Arrays;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE post set is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
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

    private Boolean is_deleted;

    private Post(String title, String content, String author, Boolean is_deleted) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.is_deleted = is_deleted;
    }

    // 정적 팩토리 메서드
    public static Post ofPosts(String title, String content, String author) {
        return new Post(title, content, author, false);
    }

    public void update(UpdatePost.Request request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
