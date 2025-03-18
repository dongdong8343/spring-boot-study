package org.example.springboot.config.error.exception;

import org.example.springboot.config.error.ErrorCode;

public class PostNotFoundException extends BusinessBaseException {
    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }

}
