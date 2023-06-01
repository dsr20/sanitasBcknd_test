package com.example.calculadora.controller;



import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.calculadora.model.ResponseDTO;
import com.example.calculadora.service.OptServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

@WebMvcTest
public class CalculadoraControllerTest {

    @Mock
    private OptServiceImpl optServiceMock;
    @Autowired
    @InjectMocks
    private CalculadoraController calculadoraCtrl;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * TU which verifies Services interaction
     * @throws Exception
     */
    @Test
    public void sumaOptTest() throws Exception {
        calculadoraCtrl.sumaOpt(new ArrayList<>());
        Mockito.verify(optServiceMock).sumarOpt(new ArrayList<>());

    }
    /**
     * TU which verifies Services interaction
     * @throws Exception
     */
    @Test
    public void restaOptTest() throws Exception {
        calculadoraCtrl.restaOpt(new ArrayList<>());
        Mockito.verify(optServiceMock,Mockito.atLeastOnce()).restarOpt(Mockito.anyList());
    }
}
