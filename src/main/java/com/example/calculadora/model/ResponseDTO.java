package com.example.calculadora.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ResponseDTO {

    @Getter
    @Setter
    private Double result;

    public ResponseDTO buildResponse(){return this;}
}
