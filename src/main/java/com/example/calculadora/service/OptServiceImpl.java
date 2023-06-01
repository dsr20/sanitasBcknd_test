package com.example.calculadora.service;

import com.example.calculadora.model.IOperacion;
import com.example.calculadora.model.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptServiceImpl implements IOptService{

    public ResponseDTO operationExec(List<String> values, IOperacion opt) {
        return null;
    }

}
