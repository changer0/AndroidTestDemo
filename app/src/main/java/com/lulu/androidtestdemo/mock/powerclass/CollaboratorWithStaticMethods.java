package com.lulu.androidtestdemo.mock.powerclass;

/**
 * Created by lulu on 2018/4/14.
 * 测试静态方法
 */
public class CollaboratorWithStaticMethods {
    public static String firstMethod(String name) {
        return "Hello " + name + " !";
    }

    public static String secondMethod() {
        return "Hello no one!";
    }

    public static String thirdMethod() {
        return "Hello no one again!";
    }
}