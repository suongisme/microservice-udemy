package me.suongnguyen.commonmodel.exception;

import lombok.Getter;
import me.suongnguyen.commonmodel.constant.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class NotFoundResourceException extends RuntimeException {

    private final BaseError baseError;

    public NotFoundResourceException(@NonNull BaseError baseError, Object...params) {
        super(MessageFormat.format(baseError.getMessage(), params));
        this.baseError = baseError;
    }
}
