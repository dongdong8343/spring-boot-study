package org.example.springboot.config.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.List;

// 에러 발생 시 클라이언트에게 전달할 에러 응답 객체
@Getter
public class ErrorResponse {
    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY) // error 비었다면 errors는 제외해라
    private final List<ValidationError> errors;

    private ErrorResponse(String code, String message, List<ValidationError> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public static ErrorResponse of(String code, String message) {
        return new ErrorResponse(code, message, null);
    }

    @Getter
    public static class ValidationError { // 유효성 검사 실패 시 발생하는 개별 필드의 오류 저장
        private final String field;
        private final String message;

        private ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public static ValidationError of(FieldError fieldError) {
            return new ValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
