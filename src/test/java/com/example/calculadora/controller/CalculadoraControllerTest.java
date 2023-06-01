package com.example.calculadora.controller;


import com.example.calculadora.service.OptServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;


import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;

@RunWith(JUnit4ClassRunner.class)
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
