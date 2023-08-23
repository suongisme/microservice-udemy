package me.suongnguyen.commonmodel.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.suongnguyen.commonmodel.constant.ResponseStatus;
import org.apache.logging.log4j.ThreadContext;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
    private ResponseStatus status;
    private String message;
    private String code;
    private String traceId;
    private String spanId;
    private T data;

    public ResponseData() {
        this.spanId = ThreadContext.get("spanId");
        this.traceId = ThreadContext.get("traceId");
    }

    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.data = data;
        responseData.status = ResponseStatus.SUCCESS;
        return responseData;
    }

    public static <T> ResponseData<T> error(String code, String message, T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.status = ResponseStatus.FAIL;
        responseData.data = data;
        responseData.code = code;
        responseData.message = message;
        return responseData;
    }
}
