package com.example.calculadora.controller;

import com.example.calculadora.exceptions.NoElementFoundException;
import com.example.calculadora.model.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.text.ParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ParseException.class)
    public ResponseEntity<Object> handleParsingException(RuntimeException ex, WebRequest req){
        return new ResponseEntity<Object>(
            "Access denied message here", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(value= NoElementFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseDTO> handleNoElementFoundException(NoElementFoundException ex, WebRequest req){
        ResponseDTO r = new ResponseDTO();
        r.setMessage(ex.getMessage());
        r.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ResponseDTO>(r,r.getStatus());

    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }


}
