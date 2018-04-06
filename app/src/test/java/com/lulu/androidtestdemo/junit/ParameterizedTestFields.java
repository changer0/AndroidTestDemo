package com.lulu.androidtestdemo.junit;

import com.lulu.androidtestdemo.junit.testexample.MyClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhanglulu on 2018/1/24.
 * 参数化测试示例
 */
@RunWith(Parameterized.class)
public class ParameterizedTestFields {
//    @Parameterized.Parameter(0)
    public int m1;
//    @Parameterized.Parameter(1)
    public int m2;
//    @Parameterized.Parameter(2)
    public int result;

    public ParameterizedTestFields(int m1, int m2, int result) {
        this.m1 = m1;
        this.m2 = m2;
        this.result = result;
    }
    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.asList(data);
    }
    @Test
    public void testMultiplyException() {
        MyClass tester = new MyClass();
        assertEquals("Result", result, tester.multiply(m1, m2));
    }
}
