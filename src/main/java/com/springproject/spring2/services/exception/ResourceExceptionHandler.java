package com.springproject.spring2.services.exception;

import com.sun.jdi.ObjectCollectedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;



@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectCollectedException.class)
    public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFound e, HttpServletRequest request){


        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "não encontrado", e.getMessage(), request.getRequestURI(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
    }
}
