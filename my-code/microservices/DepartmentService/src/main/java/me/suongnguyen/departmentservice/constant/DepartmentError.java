package me.suongnguyen.departmentservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.suongnguyen.commonmodel.constant.BaseError;

@Getter
@AllArgsConstructor
public enum DepartmentError implements BaseError {

    NOT_FOUND_DEPARTMENT("NOT_FOUND_DEPARTMENT", "not found department by code: {0}");

    private final String code;
    private final String message;
}
