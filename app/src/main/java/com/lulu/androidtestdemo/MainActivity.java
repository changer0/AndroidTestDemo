package com.lulu.androidtestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onChangeClick(View view) {
        Toast.makeText(this, view.getId()+"被点击了", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onChangeClick: 点击了");
    }
}
