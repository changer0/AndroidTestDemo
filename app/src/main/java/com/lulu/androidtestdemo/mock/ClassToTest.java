package com.lulu.androidtestdemo.mock;

/**
 * Created by zhanglulu on 2018/1/31.
 */

public class ClassToTest {
    MyDatabase myDatabase;

    public ClassToTest(MyDatabase myDatabase) {
        this.myDatabase = myDatabase;
    }

    public boolean query(String sql) {
        myDatabase.query(sql);
        System.out.println("ClassToTest query() called");
        return true;
    }

}
