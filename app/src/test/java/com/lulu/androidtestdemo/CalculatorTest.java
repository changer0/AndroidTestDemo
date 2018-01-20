package com.lulu.androidtestdemo;

import android.util.Log;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lulu on 2018/1/20.
 */
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
    }

    @Test
    public void multiply() throws Exception {
        int sum = mCalculator.multiply(1, 2);
        assertEquals(2, sum);
    }

}