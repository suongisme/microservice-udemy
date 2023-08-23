package me.suongnguyen.commonmodel.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.Objects;

@AllArgsConstructor
@Data
@Builder
public class ValidateErrorDto {
    private String fieldName;
    private String message;
    private String value;

    public ValidateErrorDto(FieldError error) {
        this.fieldName = error.getField();
        this.message = error.getDefaultMessage();
        this.value = Objects.toString(error.getRejectedValue(), null);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.value, this.fieldName, this.message);
    }
}
