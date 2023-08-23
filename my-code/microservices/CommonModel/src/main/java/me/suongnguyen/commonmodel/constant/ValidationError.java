package me.suongnguyen.commonmodel.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ValidationError implements BaseError {

    DATA_EXIST("000", "common.exist.data"),
    DATA_NOT_FOUND("001", "common.not-found.data");

    private final String code;
    private final String message;
}
