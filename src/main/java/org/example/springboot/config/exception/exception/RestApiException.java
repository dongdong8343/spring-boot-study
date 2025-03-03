package org.example.springboot.config.exception.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springboot.config.exception.errorCode.ErrorCode;

@Getter
@RequiredArgsConstructor
public class RestApiException extends RuntimeException{
    private final ErrorCode errorCode;
}
