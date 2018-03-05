package com.lulu.androidtestdemo.instrumentation;

import android.app.Application;

/**
 * Created by lulu on 2018/3/3.
 */
public class MyMockApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // do something important for your tests here
    }
}
