package com.seven.topic.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import com.seven.common.exception.SevenFunnyException;
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

    @ExceptionHandler(value = SevenFunnyException.class)
    public ResultResponse customErrorHandler(SevenFunnyException e){
        return new ResultResponse(ResultCode.valueOf(e.getMessage()));
    }
}
