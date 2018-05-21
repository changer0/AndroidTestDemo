package com.lulu.androidtestdemo.robolectric;

import android.content.Intent;

import com.lulu.androidtestdemo.MainActivity;
import com.lulu.androidtestdemo.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class RoboActivityTest {
    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        RoboActivity activity = Robolectric.setupActivity(RoboActivity.class);
        activity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}