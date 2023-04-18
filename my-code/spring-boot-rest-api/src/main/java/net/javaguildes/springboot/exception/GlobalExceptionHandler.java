package net.javaguildes.springboot.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetail handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        return ErrorDetail.builder()
                .message(Collections.singletonList(ex.getMessage()))
                .path(request.getRequestURI())
                .errorCode(ex.getErrorCode())
                .clientMessageId(ThreadContext.get("uuid"))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetail handleValidation(BindException ex, HttpServletRequest request) {
        List<String> messages = ex.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return ErrorDetail.builder()
                .message(messages)
                .errorCode("DATA_NOT_VALID")
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .clientMessageId(ThreadContext.get("uuid"))
                .build();
    }

}
