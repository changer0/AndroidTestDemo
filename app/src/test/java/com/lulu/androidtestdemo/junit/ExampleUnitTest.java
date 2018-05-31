package com.lulu.androidtestdemo.junit;

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
        Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
        assertEquals(4, 2 + 2);
    }
}