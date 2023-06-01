package com.example.calculadora.controller;



import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class CalculadoraControllerIntegrationTest {

    @Autowired
    private CalculadoraController calculadoraCtrl;

    @Autowired
    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {

    }

    @Test
    public void helloWorldTest() throws Exception {
        this.mockMvc.perform(get("/calculadora/sumar")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
    @Test
    public void SumarOpt() throws Exception {
        this.mockMvc.perform(get("/calculadora/sumar")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello User")));
    }
}
