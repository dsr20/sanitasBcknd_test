package com.example.calculadora.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {

    @RequestMapping(value="/suma", method = RequestMethod.GET)
    public String sumaOpt(@RequestParam List<String> values) {

        return "Hello World";
    }

    @RequestMapping(value="/resta", method = RequestMethod.GET)
    public String restaOpt(@RequestParam List<String> values) {

        return "Hello World";
    }
}
