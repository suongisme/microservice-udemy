package me.suongnguyen.employeeservice.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import me.suongnguyen.commonmodel.constant.ResponseStatus;
import me.suongnguyen.commonmodel.exception.BusinessException;
import me.suongnguyen.commonmodel.model.ResponseData;

import java.io.InputStream;

public class Client implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public Exception decode(String s, Response response) {
        Response.Body body = response.body();
        InputStream inputStream = body.asInputStream();
        ResponseData<?> responseData = objectMapper.readValue(inputStream, ResponseData.class);
        if (ResponseStatus.SUCCESS.equals(responseData.getStatus())) {
            return this.errorDecoder.decode(s, response);
        }
        return new BusinessException(responseData);
    }
}
