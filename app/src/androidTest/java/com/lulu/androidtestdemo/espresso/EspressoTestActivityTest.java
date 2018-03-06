package com.lulu.androidtestdemo.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by zhanglulu on 2018/3/5.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTestActivityTest {
    @Rule
    public ActivityTestRule<EspressoTest1Activity> mActivityRule =
            new ActivityTestRule<EspressoTest1Activity>(EspressoTest1Activity.class);
    @Test
    public void ensureTextChangesWork() {
        //输入文字, 并点击按钮
        onView(withId(R.id.inputField))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.changeText)).perform(click());
        //检查输入框文字是否改变
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }
}
