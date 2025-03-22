package org.example.springboot.web.dto;

import lombok.Getter;

public class UpdatePost {
    @Getter
    public static class Request {
        private String title;
        private String content;
    }
}
