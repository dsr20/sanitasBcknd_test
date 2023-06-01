package com.example.calculadora.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
public class ResponseDTO {

    @Getter
    @Setter
    private Double result = 0.0;
    @Getter
    @Setter
    private String message = "";
    @Getter
    @Setter
    private HttpStatus status;

    public ResponseDTO buildResponse(){return this;}
}
