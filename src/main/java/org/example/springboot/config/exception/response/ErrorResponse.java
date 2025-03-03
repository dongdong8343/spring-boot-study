package org.example.springboot.config.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class ErrorResponse {
    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ValidationError> errors;

    private ErrorResponse(String code, String message, List<ValidationError> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public static ErrorResponse of(String code, String message) {
        return ErrorResponse.of(code, message, null);
    }

    public static ErrorResponse of(String code, String message, List<ValidationError> errors) {
        return new ErrorResponse(code, message, errors);
    }



    @Getter
    public static class ValidationError {
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
