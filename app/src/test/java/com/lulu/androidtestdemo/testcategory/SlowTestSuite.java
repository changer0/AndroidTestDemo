package com.lulu.androidtestdemo.testcategory;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by lulu on 2018/1/25.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Suite.SuiteClasses({ A.class, B.class })
public class SlowTestSuite {

}



























































