package com.example.demo.exception.handler;

import com.example.demo.exception.BadRequestException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandling {

    @ResponseBody
    @ExceptionHandler({DataAccessException.class, BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlingSQlError(Exception exception){
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlingNotFoundError(HttpRequestMethodNotSupportedException exception){
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlingInternalError(Exception exception){
        return exception.getMessage();
    }

}
