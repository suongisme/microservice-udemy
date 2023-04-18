package me.suongnguyen.commonmodel.exception;

import lombok.Getter;
import me.suongnguyen.commonmodel.constant.BaseError;
import me.suongnguyen.commonmodel.model.ResponseData;

@Getter
public class BusinessException extends RuntimeException {

    private ResponseData<?> responseData;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ResponseData<?> responseData) {
        super(responseData.getMessage());
        this.responseData = responseData;
    }
}
