package com.lulu.androidtestdemo.espresso;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by zhanglulu on 2018/3/7.
 */
@RunWith(AndroidJUnit4.class)
public class TestIntent {

    @Rule
    public IntentsTestRule<EspressoTest1Activity> mIntentTestRule =
            new IntentsTestRule<EspressoTest1Activity>(EspressoTest1Activity.class);

    @Test
    public void triggerIntentTest() {
        onView(withId(R.id.switchActivity)).perform(click());
        intended(allOf(
                hasAction(Intent.ACTION_CALL),
                hasData("123456789"),
                toPackage(InstrumentationRegistry.getTargetContext().getPackageName()),
                hasExtra("input", "Test")
        ));
    }
}
