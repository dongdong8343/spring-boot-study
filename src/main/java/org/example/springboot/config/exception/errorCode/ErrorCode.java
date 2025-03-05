package org.example.springboot.config.exception.errorCode;

import org.springframework.http.HttpStatus;

// 특정 상황에서 발생하는 에러 코드를 도메인 별로 관리할 수 있게 함.
public interface ErrorCode {
    String name();

    HttpStatus getHttpStatus();

    String getMessage();
}
