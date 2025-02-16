package org.example.springboot.config.auth.dto;

import lombok.Getter;
import org.example.springboot.domain.user.User;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    private SessionUser(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static SessionUser fromEntity(User user){
        return new SessionUser(user.getName(), user.getEmail(), user.getPicture());
    }
}
