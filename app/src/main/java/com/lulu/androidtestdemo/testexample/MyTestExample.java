package com.lulu.androidtestdemo.testexample;

/**
 * Created by zhanglulu on 2018/1/26.
 * 实际代码中的类
 */
public class MyTestExample {
    public int multiply(int x, int y) {
        // the following is just an example
        if (x > 999) {
            throw new IllegalArgumentException("X should be less than 1000");
        }
        return x / y;
    }
}
