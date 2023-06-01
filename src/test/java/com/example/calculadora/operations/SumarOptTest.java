package com.example.calculadora.operations;

import org.junit.Assert;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

/**
 * Test Class who perfoms Sumar Operations and return de result
 */
public class SumarOptTest {


    /**
     * TU which verifies Services interaction
     * @throws Exception
     */
    @Test
    public void sumaOptTest() throws Exception {
        SumarOpt sumarOpt = new SumarOpt();
        List<Double> vals = Arrays.asList(4.0,2.0);

        Assert.assertTrue(sumarOpt.exec(vals)==6.0);
    }
}
