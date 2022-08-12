package com.bridgelabz.employeepayrollapps.advice;

import com.bridgelabz.employeepayrollapps.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationHandlerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> invalidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> errorMap=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> userNotFound(UserNotFoundException userNotFoundException) {
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error-message",userNotFoundException.getMessage());
        return errorMap;
    }



}
