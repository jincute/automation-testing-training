package com.ecvictor.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by caoc on 3/18/2017.
 */
public class CalculatorTest {
    @Test
    public void add() throws Exception {
        Assert.assertTrue(Calculator.add(1,2)==3);
    }

    @Test
    public void divide() throws Exception {
        Assert.assertTrue(Calculator.divide(1, 2) == 0);
        Assert.assertEquals("1/2 should be 0",
                0, Calculator.divide(1, 2));
    }

    @Test
    public void divide1() throws Exception {
        int result = 0;
        Throwable tx = null;

        try {
            result = Calculator.divide(1,0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx = e;

        }
        //Assert.assertEquals(Exception.class, tx.getClass());// 抛出的异常类型是否和期望一致
        Assert.assertEquals("J can't equal to 0", " j can't equal to 0 ", tx.getMessage());// 抛出的异常信息是否和期望一致
    }

}