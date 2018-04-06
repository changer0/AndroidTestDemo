package com.lulu.androidtestdemo.junit.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by zhanglulu on 2018/1/24.
 */
public class LoopRule implements TestRule {
    private Statement base;
    private Description description;
    private int loopCount;

    public LoopRule(int loopCount) {
        this.loopCount = loopCount;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        this.base = base;
        this.description = description;
        System.out.println("apply");
        return new LoopStatement(base);
    }

    public class LoopStatement extends Statement {
        private final Statement base;
        public LoopStatement(Statement base) {
            this.base = base;
        }
        @Override
        public void evaluate() throws Throwable {
            for (int i = 0; i < loopCount; i++) {
                System.out.println("Loop " + i + " Started");
                base.evaluate();
                System.out.println("Loop " + i + " Finished");
            }
        }
    }
}
