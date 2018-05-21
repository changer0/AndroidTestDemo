package com.lulu.androidtestdemo.robolectric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lulu.androidtestdemo.MainActivity;
import com.lulu.androidtestdemo.R;

public class RoboActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robo);
        final View button = findViewById(R.id.login);
        button.setOnClickListener(view -> startActivity(new Intent(RoboActivity.this, MainActivity.class)));
    }
}
