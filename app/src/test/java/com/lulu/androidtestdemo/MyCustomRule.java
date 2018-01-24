package com.lulu.androidtestdemo;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by zhanglulu on 2018/1/24.
 */

public class MyCustomRule implements TestRule {
    private Statement base;
    private Description description;

    @Override
    public Statement apply(Statement base, Description description) {
        this.base = base;
        this.description = description;
        return new MyStatement(base);
    }

    public class MyStatement extends Statement {
        private final Statement base;
        public MyStatement(Statement base) {
            this.base = base;
        }
        @Override
        public void evaluate() throws Throwable {
            System.out.println(description.getMethodName() + " -> Started");
            try {
                base.evaluate();
            } finally {
                System.out.println(description.getMethodName() + " -> Finished");
            }
        }
    }
}
