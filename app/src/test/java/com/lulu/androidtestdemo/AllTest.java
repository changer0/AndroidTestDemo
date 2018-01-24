package com.lulu.androidtestdemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Created by zhanglulu on 2018/1/24.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
 MyClassTest.class,CalculatorTest.class
})
public class AllTest {
}
