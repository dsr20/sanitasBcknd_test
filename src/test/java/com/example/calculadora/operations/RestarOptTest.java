package com.example.calculadora.operations;

import org.junit.Assert;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

/**
 * Test Class who perfoms Restar Operations and return de result
 */
public class RestarOptTest {

    /**
     * TU which verifies Services interaction
     * @throws Exception
     */
    @Test
    public void restartOptTest() throws Exception {
        RestarOpt restarOpt = new RestarOpt();
        List<Double> vals = Arrays.asList(4.0,2.0);

        Assert.assertTrue(restarOpt.exec(vals)==-2.0);
    }
}
