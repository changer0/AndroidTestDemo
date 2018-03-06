package com.lulu.androidtestdemo.espresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lulu.androidtestdemo.R;

public class EspressoTest2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_test2);
        TextView viewById = (TextView) findViewById(R.id.resultView);
        Bundle inputData = getIntent().getExtras();
        if (inputData != null) {
            String input = inputData.getString("input");
            viewById.setText(input);
        }
    }

    public void onClick(View view) {
        Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
    }
}
