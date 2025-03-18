package org.example.springboot.config.error.exception;

import org.example.springboot.config.error.ErrorCode;

// 비즈니스 로직 작성하다 발생하는 예외를 모아둘 최상위 클래스
public class BusinessBaseException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessBaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessBaseException(ErrorCode code) {
        super(code.getMessage());
        this.errorCode = code;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
