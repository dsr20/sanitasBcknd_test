package com.example.calculadora.operations;

import java.util.List;

/**
 * Class who perfoms Restar Operations and return de result
 */
public class RestarOpt implements IOperacion {
    @Override
    public Double exec(List<Double> values) {
        Double result = 0.0;
        for(Double val:values){
            result = val - result;
        }
        return result;
    }
}
