package com.lulu.androidtestdemo.instrumentation;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.lulu.androidtestdemo.R;
import com.lulu.androidtestdemo.SecondActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

/**
 * Created by zhanglulu on 2018/2/26.
 */
@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> rule = new ActivityTestRule<SecondActivity>(SecondActivity.class){
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();//如果使用context,请使用getTargetContext
            Intent intent = new Intent();
            intent.putExtra("key", "这是一个测试奥");
            return intent;
        }
    };

    @Test
    public void ensureIntentDataIsDisplayed() throws Exception{
        SecondActivity activity = rule.getActivity();

        View viewById = activity.findViewById(R.id.target_text);
        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(TextView.class));
        String text = ((TextView) viewById).getText().toString();
        assertThat(text, is("这是一个测试奥"));
    }
}