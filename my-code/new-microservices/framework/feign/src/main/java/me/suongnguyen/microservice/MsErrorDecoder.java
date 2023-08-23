package me.suongnguyen.microservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.InputStream;

public class MsErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {
        try (InputStream inputStream = response.body().asInputStream()) {
            ResponseData<?> responseData = this.objectMapper.readValue(inputStream, ResponseData.class);
            if (ResponseStatus.SUCCESS.equals(responseData.getStatus())) {
                return this.errorDecoder.decode(s, response);
            }
            return new MsException(responseData);
        } catch (Exception ex) {
            return new Exception(ex.getMessage());
        }
    }
}
