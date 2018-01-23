package com.lulu.androidtestdemo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;

/**
 * Created by lulu on 2018/1/20.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        MyClassTest.class})
public class CalculatorTest {

    Calculator mCalculator;
    private static final String TAG = "CalculatorTest";

    @Before
    public void setup() {
        mCalculator = new Calculator();
        System.out.println("setup执行了");
    }

    @Test
    @Ignore
    public void add() throws Exception {
        int sum = mCalculator.add(1, 2);
        assertEquals(3, sum);
        System.out.println("add执行了");
    }

   @Test
    public void multiply() throws Exception {
        int sum = mCalculator.multiply(1, 2);
        assertEquals(23, sum);
       System.out.println("multiply执行了");
    }

}