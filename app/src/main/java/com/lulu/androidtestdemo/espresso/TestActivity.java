package com.lulu.androidtestdemo.espresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lulu.androidtestdemo.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onButtonClick(View view) {
        Toast.makeText(this, "View Clicked", Toast.LENGTH_SHORT).show();
    }
}
