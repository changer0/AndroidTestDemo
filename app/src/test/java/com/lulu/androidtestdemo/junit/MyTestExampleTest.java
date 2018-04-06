package com.lulu.androidtestdemo.junit;

import com.lulu.androidtestdemo.junit.testexample.MyTestExample;

import org.junit.Test;

import java.util.Arrays;

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
//        MyTestExample tester = new MyTestExample();
//        assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));

        String string = ",-1,-1,-1,-1,6";
        String[] split = string.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.print("输出:"+split[i] + " ");
        }
        System.out.println();
        System.out.println("把第1个参数置为1");
        split[1] = "1";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            stringBuilder.append(",");
            stringBuilder.append(split[i]);
        }
        string = stringBuilder.toString();
        System.out.println(string);

    }
}