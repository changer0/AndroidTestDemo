package com.lulu.androidtestdemo.espresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lulu.androidtestdemo.R;
import com.lulu.androidtestdemo.SecondActivity;

public class TestConfigureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_configure);
    }
    // 外部调用
    public void configureActivity(String Uri) {
        // do something with this
    }

    public void onClick(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
