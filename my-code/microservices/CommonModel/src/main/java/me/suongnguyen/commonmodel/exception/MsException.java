package me.suongnguyen.commonmodel.exception;

import lombok.Getter;
import me.suongnguyen.commonmodel.model.common.ResponseData;

@Getter
public class MsException extends RuntimeException {

    private final ResponseData<?> responseData;

    public MsException(ResponseData<?> responseData) {
        super(responseData.getMessage());
        this.responseData = responseData;
    }

}
