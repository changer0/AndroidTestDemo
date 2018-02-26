package com.lulu.androidtestdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {
        Log.d(TAG, "MyService: Started");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyLocalBinder();
    }

    class MyLocalBinder extends Binder {
        public MyService getMyService() {
            return MyService.this;
        }
    }

    /**
     * 测试方法
     * @return
     */
    public String doSomethingToReturnTest() {
        return "Test";
    }

}
