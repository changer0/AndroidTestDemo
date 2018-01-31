package com.lulu.androidtestdemo;

import com.lulu.androidtestdemo.junit.testexample.MyClass;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;
/**
 * Created by zhanglulu on 2018/1/23.
 */
public class MyClassTest {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MyClass tester = new MyClass(); // MyClass is tested

        // assert statements
        assertEquals("0 x 0 must be 0",0, tester.multiply(0, 0));
        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));

        Result result = JUnitCore.runClasses(CalculatorTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}