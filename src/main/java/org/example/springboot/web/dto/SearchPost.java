package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.posts.Post;

public class SearchPost {
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

        public static Response fromEntity(Post entity){
            return new Response(entity.getId(), entity.getTitle(), entity.getContent(), entity.getAuthor());
        }
    }
}
