package com.lulu.androidtestdemo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by zhanglulu on 2018/1/24.
 * JUnit Rules
 */
public class RuleExceptionTesterExample {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionIfIconIsNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negative value not allowed");
        ClassToBeTested t = new ClassToBeTested();
        t.methodToBeTest(-1);
    }
}

class ClassToBeTested {

    public void methodToBeTest(int i) {
        if (i == -1) {
            throw new IllegalArgumentException("Negative value not allowed");
        }
    }
}
