package me.suongnguyen.commonmodel.exception;

import lombok.extern.slf4j.Slf4j;
import me.suongnguyen.commonmodel.model.ResponseData;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static me.suongnguyen.commonmodel.constant.ResponseStatus.FAIL;

@Primary
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<?> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        ResponseData<?> responseData = new ResponseData<>();
        responseData.setStatus(FAIL);
        responseData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
        responseData.setMessage(ex.getMessage());
        return responseData;
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData<?> handleBusinessException(BusinessException ex) {
        log.error(ex.getMessage(), ex);
        return ex.getResponseData();
    }

    @ExceptionHandler({NotFoundResourceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData<?> handleNotFoundResourceException(NotFoundResourceException ex) {
        log.error(ex.getMessage(), ex);
        ResponseData<?> responseData = new ResponseData<>();
        responseData.setStatus(FAIL);
        responseData.setMessage(ex.getMessage());
        responseData.setCode(ex.getBaseError().getCode());
        return responseData;
    }
}
