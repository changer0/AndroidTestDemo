package com.lulu.androidtestdemo;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Assume.assumeFalse(System.getProperty("os.name").contains("Windows"));
        System.out.println("测试输出");
        assertEquals(4, 2 + 2);
    }
}