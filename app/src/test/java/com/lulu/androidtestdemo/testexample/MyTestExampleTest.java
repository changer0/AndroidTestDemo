package com.lulu.androidtestdemo.testexample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhanglulu on 2018/1/26.
 */
public class MyTestExampleTest {

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown() {
        MyTestExample tester = new MyTestExample();
        tester.multiply(1000, 5);
    }

    @Test
    public void multiply() throws Exception {
        MyTestExample tester = new MyTestExample();
        assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
    }
}