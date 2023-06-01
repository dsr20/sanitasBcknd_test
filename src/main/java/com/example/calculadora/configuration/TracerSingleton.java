package com.example.calculadora.configuration;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

import java.util.Objects;


public class TracerSingleton {

    private static TracerImpl instance;

    private TracerSingleton(){
        // Do nothing
    }
    public static synchronized TracerImpl getInstance(){
        if(Objects.isNull(instance)){
            instance = new TracerImpl();
        }
        return instance;
    }
}
