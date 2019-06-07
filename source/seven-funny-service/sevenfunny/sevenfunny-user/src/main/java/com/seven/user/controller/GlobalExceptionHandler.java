package com.seven.user.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultResponse defaultErrorHandler(Exception e){
        return new ResultResponse(ResultCode.ERROR, e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResultResponse customErrorHandler(RuntimeException e){
        return new ResultResponse(ResultCode.valueOf(e.getMessage()));
    }
}
