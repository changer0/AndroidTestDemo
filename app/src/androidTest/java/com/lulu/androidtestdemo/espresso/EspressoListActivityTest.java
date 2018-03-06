package com.lulu.androidtestdemo.espresso;

import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by zhanglulu on 2018/3/6.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoListActivityTest {

    @Rule
    public ActivityTestRule<EspressoListActivity> mRule =
            new ActivityTestRule<EspressoListActivity>(EspressoListActivity.class);


    @Before
    public void grantPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getInstrumentation().getUiAutomation().executeShellCommand(
                    "pm grant " + getInstrumentation().getTargetContext().getPackageName()
                            + " android.permission.CALL_PHONE");
        }
    }

    @Test
    public void testList() {
        // 点击 ListView 中文本为 "测试 15" 的 item
        onData(allOf(is(instanceOf(String.class)), is("测试 30")))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), is("测试 1")))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), is("测试 49")))
                .perform(click());
    }



}