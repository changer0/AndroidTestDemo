package com.lulu.androidtestdemo.junit.rule;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by zhanglulu on 2018/1/24.
 */

public class TestLoopRule {
    @Rule
    public LoopRule customRule = new LoopRule(3);

    @Test
    public void testMyCustomRule() {
        System.out.println("execute testMyCustomRule");
    }

}
