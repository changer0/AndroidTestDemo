package com.lulu.androidtestdemo.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.R;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class EspressoJumpTest {

    @Rule
    public ActivityTestRule<EspressoTest1Activity> mRule =
            new ActivityTestRule<>(EspressoTest1Activity.class);

    @Test
    public void testSecondActivity() throws Exception {
        onView(withId(R.id.inputField)).check(matches(isDisplayed()))
                .perform(typeText("This is Text"), closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).check(matches(isDisplayed()))
                .perform(click());
        //Thread.sleep(500);
        onView(withText("This is Text")).check(matches(isDisplayed()))
                .perform(click());
    }
    @After
    public void after() throws Exception{
        Thread.sleep(5000);
    }
}
