package com.lulu.androidtestdemo.junit;

import com.lulu.androidtestdemo.junit.CalculatorTest;
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

    @Test
    public void translateHeaderStr() throws Exception {
        String str = "loginType=10, timi=34100001165, timestamp=1522805590, sid=15115292207, safekey=0E33FBED91506771C63D435991919653, c_version=oppobook_3.0.5.300_android_oppo, usid=TOKEN_HluJk3yfgHdYw5+TrBtBY3JtQy/Ptp0N85m3xfrv2zmb6V1Hztm1wUMqy+huprqU, channel=10014327, type=102712_0;102711_0;102761_0;102709_0;102713_0;102736_0;102763_0;102764_0;102710_0;102997_0;103164_0;103615_0;102762_0;102857_0;102759_0;103007_0;102760_0;102668_0;103122_0;, vcheck=1, nosid=1, cplatform=oppo, gselect=1, ywkey=ywtaZugupsFK, density=3.0, qimei=869545023829181_02:00:00:00:00:00, os=android, c_platform=oppo, supportTS=1, mversion=3.0.5.300, qqnum=34100001165, ua=libra#libra#24, device_model=1KibMxO5wCqVhFq5dwyA8w==, uid=34100001165, resolution=1080*1920";
        String[] strings = str.split(",");
        for (int i = 0; i < strings.length; i++) {
            String[] singles = strings[i].split("=");
            if (singles.length > 1) {
                System.out.println(singles[0].trim() + ":" + singles[1].trim());
            }
        }
    }
}