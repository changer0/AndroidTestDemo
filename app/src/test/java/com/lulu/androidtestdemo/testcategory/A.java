package com.lulu.androidtestdemo.testcategory;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

/**
 * Created by lulu on 2018/1/25.
 */

public class A {
    @Test
    public void a() {
        fail();
    }
    @Category(SlowTests.class)
    @Test
    public void b() {
    }
}
