package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.posts.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReadPosts {
    @Getter
    public static class Response {
        private Long id;
        private String title;
        private String author;
        private LocalDateTime modifiedDate;

        public Response(Post entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.modifiedDate = entity.getModifiedDate();
        }

        public static ReadPosts.Response toResponse(Post post) {
            return new Response(post);
        }

        public static List<Response> toResponse(List<Post> posts) {
            return posts.stream()
                    .map(Response::toResponse)
                    .toList();
        }
    }
}
