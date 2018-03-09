package com.lulu.androidtestdemo.espresso;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lulu.androidtestdemo.R;
import com.lulu.androidtestdemo.espresso.utils.EspressoIdlingResource;
public class TestActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        text = findViewById(R.id.text);
    }

    public void onButtonClick(View view) {
        EspressoIdlingResource.increment();
        Toast.makeText(this, "View Clicked", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.my_view:
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        mHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
                break;
            case R.id.my_view2:
                text.setText("Running");
                break;
        }

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            text.setText("Done");
            if (!EspressoIdlingResource.getIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }
    };

    @VisibleForTesting
    public IdlingResource getIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }

}
