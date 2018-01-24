package com.lulu.androidtestdemo;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by zhanglulu on 2018/1/24.
 */

public class TestMyCustomRule {
    @Rule
    public MyCustomRule customRule = new MyCustomRule();

    @Test
    public void testMyCustomRule() {
//        customRule
        System.out.println("执行testMyCustomRule");
    }
}
