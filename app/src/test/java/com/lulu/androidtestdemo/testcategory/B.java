package com.lulu.androidtestdemo.testcategory;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by lulu on 2018/1/25.
 */
@Category({ SlowTests.class, FastTests.class })
public class B {
    @Test
    public void c() {
    }

}
