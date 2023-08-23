package me.suongnguyen.commonmodel.exception;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.suongnguyen.commonmodel.constant.BaseError;
import me.suongnguyen.commonmodel.model.common.ResponseData;
import me.suongnguyen.commonmodel.model.common.ValidateErrorDto;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Primary;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import static me.suongnguyen.commonmodel.constant.ResponseStatus.FAIL;

@Primary
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;
    private final Tracer tracer;

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<?> handleException(Exception ex) {
        String message = this.translate(ex.getMessage());
        log.error(message, ex);
        this.addZipkin(ex, message);
        ResponseData<?> responseData = new ResponseData<>();
        responseData.setStatus(FAIL);
        responseData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
        responseData.setMessage(ex.getMessage());
        return responseData;
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData<?> handleBusinessException(BusinessException ex) {
        String translate = this.translate(ex.getMessage(), ex.getArgs());
        log.error(translate, ex);
        this.addZipkin(ex, translate);
        BaseError baseError = ex.getBaseError();
        return ResponseData.error(baseError.getCode(), translate, null);
    }

    @ExceptionHandler({MsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData<?> handleMsException(MsException ex) {
        log.error(ex.getMessage(), ex);
        this.addZipkin(ex, ex.getMessage());
        return ex.getResponseData();
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData<List<ValidateErrorDto>> handleBindException(BindException ex) {
        log.error(ex.getMessage(), ex);
        this.addZipkin(ex, ex.getMessage());
        List<ValidateErrorDto> validateErrorDtos = ex.getFieldErrors()
                .stream()
                .map(ValidateErrorDto::new)
                .peek(x -> {
                    String translate = this.translate(x.getMessage());
                    x.setMessage(translate);
                })
                .toList();
        return ResponseData.error("400", validateErrorDtos.toString(), validateErrorDtos);
    }

    private String translate(String code, Object...params) {
        try {
            return this.messageSource.getMessage(code, params, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException ex) {
            return MessageFormat.format(code, params);
        }
    }

    private void addZipkin(Throwable ex, String message) {
        Span span = this.tracer.currentSpan();
        if (Objects.isNull(span)) return;

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        String error = stringWriter.toString();
        span.tag("error", error);
        span.tag("message", message);
        span.tag("exception", ex.getClass().getSimpleName());
    }
}
