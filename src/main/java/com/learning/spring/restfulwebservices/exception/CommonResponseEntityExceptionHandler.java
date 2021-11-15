package com.learning.spring.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//classes that can be shared across multiple classes
@ControllerAdvice
@RestController
public class CommonResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllException(Exception ex, WebRequest request){

       CommonExceptionResponse commonExceptionResponse =  new CommonExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

       return new ResponseEntity(commonExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFountException.class)
    public final ResponseEntity<Object> handlerUserNotFoundException(UserNotFountException ex, WebRequest request){

        CommonExceptionResponse commonExceptionResponse =  new CommonExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(commonExceptionResponse, HttpStatus.NOT_FOUND);

    }

}
