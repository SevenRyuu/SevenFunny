package com.seven.user.controller;

import com.seven.common.entity.ResultCode;
import com.seven.common.entity.ResultResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultResponse defaultErrorHandler(Exception e){
        return new ResultResponse(ResultCode.ERROR, e.getMessage());
    }
}
