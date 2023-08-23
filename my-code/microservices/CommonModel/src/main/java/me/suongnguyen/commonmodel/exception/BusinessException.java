package me.suongnguyen.commonmodel.exception;

import lombok.Getter;
import me.suongnguyen.commonmodel.constant.BaseError;

@Getter
public class BusinessException extends RuntimeException {

    private final BaseError baseError;
    private final Object[] args;

    public BusinessException(BaseError baseError, Object...param) {
        super(baseError.getMessage());
        this.baseError = baseError;
        this.args = param;
    }
}
