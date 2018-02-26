package com.lulu.androidtestdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView viewById = (TextView) findViewById(R.id.target_text);
        Intent intent = getIntent();
        if (intent != null) {
            String key = intent.getStringExtra("key");
            if (key != null) {
                viewById.setText(key);
                Log.d(TAG, "onCreate: key: " + key);
            }
        }
    }
}
