package com.example.calculadora.service;

import com.example.calculadora.model.ResponseDTO;
import com.example.calculadora.operations.SumarOPT;

import java.util.List;

public interface IOptService {
    public ResponseDTO sumarOpt(List<String> values);

    public ResponseDTO restarOpt(List<String> values);
}
