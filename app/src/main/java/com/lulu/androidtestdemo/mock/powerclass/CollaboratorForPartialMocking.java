package com.lulu.androidtestdemo.mock.powerclass;

/**
 * Created by lulu on 2018/4/14.
 */
public class CollaboratorForPartialMocking {
    public static String staticMethod() {
        return "Hello Lulu!";
    }

    public final String finalMethod() {
        return "Hello Lulu!";
    }

    private String privateMethod() {
        return "Hello Lulu!";
    }

    public String privateMethodCaller() {
        return privateMethod() + " Welcome to the Java world.";
    }
}