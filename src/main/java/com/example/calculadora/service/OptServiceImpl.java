package com.example.calculadora.service;

import com.example.calculadora.configuration.TracerSingleton;
import com.example.calculadora.exceptions.ParsingException;
import com.example.calculadora.operations.IOperacion;
import com.example.calculadora.model.ResponseDTO;
import com.example.calculadora.operations.RestarOpt;
import com.example.calculadora.operations.SumarOpt;
import io.micrometer.common.util.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OptServiceImpl implements IOptService{
    Logger logger = LogManager.getLogger(OptServiceImpl.class);
    /**
     * Implementation of sumar Action
     * @param values list of values
     * @return response with the result
     */
    @Override
    public ResponseDTO sumarOpt(List<String> values) throws ParsingException {
        logger.trace("Init - sumarOPT");
        SumarOpt sumar = new SumarOpt();
        return operationExec(values,sumar);
    }

    /**
     * Implementation of restar Action
     * @param values list of values
     * @return response with the result
     */
    @Override
    public ResponseDTO restarOpt(List<String> values) throws ParsingException {
        logger.trace("Init - restarOpt");
        RestarOpt restarOpt = new RestarOpt();
        return operationExec(values,restarOpt);
    }

    /**
     * Method who do the parsing of parameters
     * @param values list of Parameters
     * @param opt operation to perform
     * @return result
     */
    private ResponseDTO operationExec(List<String> values, IOperacion opt) throws ParsingException {
        List<Double> listValues = checkValues(values);
        ResponseDTO resp = new ResponseDTO();

        resp.setResult(opt.exec(listValues));

        // Using Tracer API
        TracerSingleton.getInstance().trace(resp.getResult());
        return resp.buildResponse();
    }

    /**
     * Method who parse the list of input values
     * @param values list of Parameters
     * @return list of parsed Integer values
     */
    private List<Double> checkValues(List<String> values) throws ParsingException {
        if(Objects.isNull(values)){
            return new ArrayList<>();
        }

        values = values.stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());

        // Check if str is numeric
        for(String str: values){
            if(!isNumeric(str)){
                logger.error("checkValues:: Error when parsing values");
                TracerSingleton.getInstance().trace("checkValues:: Error when parsing values");
                return new ArrayList<>();
            }
        }

        List<Double> res = values.stream().map( value -> Double.valueOf(value)).collect(Collectors.toList());
        logger.debug("checkValues:: res {}",res.toString());
        return res;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }



}
