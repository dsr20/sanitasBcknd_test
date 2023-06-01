package com.example.calculadora.controller;



import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@Ignore // Imposible to run de TI
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculadoraControllerIntegrationTest {

    @Autowired
    private CalculadoraController calculadoraCtrl;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void restarOptTest() throws Exception {
        MultiValueMap<String,String> para = new LinkedMultiValueMap<>();
        para.add("values","1.0");
        para.add("values","2.0");
        this.mockMvc.perform(get("/calculadora/restar").params(para)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
    @Test
    public void sumarOptTest() throws Exception {
        MultiValueMap<String,String> para = new LinkedMultiValueMap<>();
        para.add("values","1.0");
        para.add("values","2.0");
        this.mockMvc.perform(get("/calculadora/sumar").param("1.0","2.0")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello User")));
    }
}
