package com.example.calculadora.controller;

import com.example.calculadora.model.ResponseDTO;
import com.example.calculadora.service.OptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {

    @Autowired
    private OptServiceImpl optService;

    @RequestMapping(value="/suma", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO sumaOpt(@RequestParam List<String> values) {

        return optService.sumarOpt(values);
    }

    @RequestMapping(value="/resta", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO restaOpt(@RequestParam List<String> values) {

        return optService.restarOpt(values);
    }
}
