package com.example.calculadora.service;

import com.example.calculadora.operations.IOperacion;
import com.example.calculadora.model.ResponseDTO;
import com.example.calculadora.operations.SumarOPT;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptServiceImpl implements IOptService{

    /**
     * Implementation of sumar Action
     * @param values list of values
     * @return response with the result
     */
    @Override
    public ResponseDTO sumarOpt(List<String> values){
        SumarOPT sumar = new SumarOPT();
        return operationExec(values,sumar);
    }

    /**
     * Implementation of restar Action
     * @param values list of values
     * @return response with the result
     */
    @Override
    public ResponseDTO restarOpt(List<String> values){
        SumarOPT sumar = new SumarOPT();
        return operationExec(values,sumar);
    }

    /**
     * Method who do the parsing of parameters
     * @param values list of Parameters
     * @param opt operation to perform
     * @return result
     */
    private ResponseDTO operationExec(List<String> values, IOperacion opt) {
        List<Integer> listValues = new ArrayList<>();
        ResponseDTO resp = new ResponseDTO();
        resp.setResult(opt.exec(listValues));
        return resp.buildResponse();
    }

}
