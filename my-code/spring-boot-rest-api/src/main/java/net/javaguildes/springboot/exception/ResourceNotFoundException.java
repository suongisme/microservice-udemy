package net.javaguildes.springboot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String fieldName;
    private final String fieldValue;
    private final String errorCode;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue, String errorCode) {
        super(String.format("[%s] not found %s: %s", resourceName.toUpperCase(), fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
        this.errorCode = errorCode;
    }
}
