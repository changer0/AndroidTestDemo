package com.lulu.androidtestdemo.espresso;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lulu.androidtestdemo.R;

public class UIHandleActivity extends AppCompatActivity {

    public TextView mTextView;
    private static int count = 0;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mTextView.setText(String.valueOf(count++));
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uihandle);
        mTextView = ((TextView) findViewById(R.id.text));
        mHandler.sendEmptyMessageDelayed(0, 5000);
    }
}
