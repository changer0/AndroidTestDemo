package com.lulu.androidtestdemo.instrumentation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.lulu.androidtestdemo.MainActivity;

/**
 * Created by zhanglulu on 2018/2/26.
 */

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    public static final String TEST_RECEIVER = "test_receiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 执行了");
        if (TEST_RECEIVER.equalsIgnoreCase(intent.getAction())) {
            String value = intent.getStringExtra("key");
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("key", value);
            context.startActivity(i);
        }
    }
}
