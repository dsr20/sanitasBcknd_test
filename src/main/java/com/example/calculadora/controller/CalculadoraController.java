package com.example.calculadora.controller;

import com.example.calculadora.exceptions.ParsingException;
import com.example.calculadora.model.ResponseDTO;
import com.example.calculadora.service.OptServiceImpl;
import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity sumaOpt(@RequestParam List<String> values) throws ParsingException {
        ResponseDTO r = optService.sumarOpt(values);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @RequestMapping(value="/resta", method = RequestMethod.GET)
    public ResponseEntity restaOpt(@RequestParam List<String> values) throws ParsingException {
        ResponseDTO r = optService.restarOpt(values);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
