package org.example.springboot.web.dto;

import lombok.AllArgsConstructor;
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

        public Post toEntity(){
            return Post.ofPosts(this.title, this.content, this.author);
        }
    }
}
