package com.lulu.androidtestdemo.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class UIHandleActivityTest {

    private static final String TAG = "UIHandleActivityTest";

    @Rule
    public ActivityTestRule<UIHandleActivity> mRule = new ActivityTestRule<>(UIHandleActivity.class);

    @Test
    public void testMethod() {
        Log.d(TAG, "testMethod: ");
    }


}