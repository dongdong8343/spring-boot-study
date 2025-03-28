package org.example.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Post;

public class SavePost {
    @Getter
    @NoArgsConstructor
    public static class Request {
        private String title;
        private String content;
        private String author;

        public Post toEntity() {
            return Post.ofPosts(this.title, this.content, this.author);
        }
    }

    @Getter
    public static class Response {
        private Long id;
        private String title;
        private String content;
        private String author;

        private Response(Long id, String title, String content, String author) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public static Response toResponse(Post post) {
            return new Response(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
        }
    }
}
