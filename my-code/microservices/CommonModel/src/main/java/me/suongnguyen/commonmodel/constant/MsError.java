package me.suongnguyen.commonmodel.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MsError implements BaseError {

    SAMPLE_ERROR("suong", "suong");

    private final String message;
    private final String code;
}
