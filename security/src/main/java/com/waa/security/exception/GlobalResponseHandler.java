package com.waa.security.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletResponse res = ((ServletServerHttpResponse) response).getServletResponse();
        if (res.getStatus() != 200||body instanceof ApiResponse) {
            System.out.println(res);
            return body;
        }
        ApiResponse<Object> output = new ApiResponse<>();
        output.setData(body);
        output.setStatus(HttpStatus.OK.value());
        output.setTimestamp(LocalDateTime.now());
        output.setMessage("Success");
        return output;
    }

}