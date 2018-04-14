package com.lulu.androidtestdemo.mock.powerclass;

/**
 * Created by lulu on 2018/4/14.
 */
public class CollaboratorForPartialMocking {
    public static String staticMethod() {
        return "Hello Baeldung!";
    }

    public final String finalMethod() {
        return "Hello Baeldung!";
    }

    private String privateMethod() {
        return "Hello Baeldung!";
    }

    public String privateMethodCaller() {
        return privateMethod() + " Welcome to the Java world.";
    }
}