package com.lulu.androidtestdemo.espresso;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.R;
import com.lulu.androidtestdemo.espresso.TestActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

/**
 * Created by zhanglulu on 2018/3/8.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoAsyncTest {
    private IdlingResource idlingresource;

    @Rule
    public ActivityTestRule<TestActivity> activityRule = new ActivityTestRule(TestActivity.class);

    @Before
    public void before() {
        //调用Activity中我们已经设置好的getIdlingresource()方法，获取Idlingresource对象
        idlingresource = activityRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(idlingresource);
    }
    @After
    public void after() {
        IdlingRegistry.getInstance().unregister(idlingresource);
    }

    @Test //is(String.class), is("Done")
    public void testAsync() {
        onView(withId(R.id.my_view)).perform(click());
        onView(withId(R.id.text)).check(matches(withText("Done")));
    }

}
