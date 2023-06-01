package com.example.calculadora.configuration;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

import java.util.Objects;


public class TracerSingleton {

    private static TracerAPI instance;

    private TracerSingleton(){
        // Do nothing
    }
    public static synchronized TracerAPI getInstance(){
        if(Objects.isNull(instance)){
            instance = (TracerAPI) new TracerImpl();
        }
        return instance;
    }
}
