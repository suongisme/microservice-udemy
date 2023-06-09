package me.suongnguyen.commonmodel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.suongnguyen.commonmodel.constant.ResponseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
    private ResponseStatus status;
    private String message;
    private String code;
    private T data;

    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.data = data;
        responseData.status = ResponseStatus.SUCCESS;
        return responseData;
    }
}
