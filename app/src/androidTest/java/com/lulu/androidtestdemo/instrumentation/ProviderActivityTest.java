package com.lulu.androidtestdemo.instrumentation;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.ProviderActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by zhanglulu on 2018/2/27.
 */

@RunWith(AndroidJUnit4.class)
public class ProviderActivityTest {

    @Rule
    public ActivityTestRule<ProviderActivity> rule = new ActivityTestRule<ProviderActivity>(ProviderActivity.class);



    @Test
    public void testProviderActivity() {

    }
}
