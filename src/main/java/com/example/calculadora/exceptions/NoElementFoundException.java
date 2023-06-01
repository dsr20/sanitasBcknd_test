package com.example.calculadora.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoElementFoundException extends RuntimeException{
    public NoElementFoundException() {
        super();
    }
    public NoElementFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoElementFoundException(String message) {
        super(message);
    }
    public NoElementFoundException(Throwable cause) {
        super(cause);
    }
}
