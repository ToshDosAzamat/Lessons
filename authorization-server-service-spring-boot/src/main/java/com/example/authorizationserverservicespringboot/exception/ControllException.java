package com.example.authorizationserverservicespringboot.exception;


import com.example.authorizationserverservicespringboot.dto.ExceptionMesssge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runexception(RuntimeException exception){
        ExceptionMesssge exceptionMesssge = ExceptionMesssge.builder()
                .date(new Date())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(exceptionMesssge, HttpStatus.NOT_FOUND);
    }
}
