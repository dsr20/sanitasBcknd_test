package com.example.calculadora.service;

import com.example.calculadora.model.IOperacion;
import com.example.calculadora.model.ResponseDTO;

import java.util.List;

public interface IOptService {

    public ResponseDTO operationExec(List<String> values, IOperacion opt);
}
