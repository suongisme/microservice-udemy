package me.suongnguyen.commonmodel.exception;

import lombok.Getter;
import me.suongnguyen.commonmodel.constant.BaseError;

@Getter
public class BusinessException extends RuntimeException {

    private BaseError baseError;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(BaseError baseError) {
        super(baseError.getMessage());
        this.baseError = baseError;
    }
}
