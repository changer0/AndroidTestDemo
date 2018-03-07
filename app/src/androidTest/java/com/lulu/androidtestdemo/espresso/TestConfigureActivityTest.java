package com.lulu.androidtestdemo.espresso;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;

import com.lulu.androidtestdemo.SecondActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static org.junit.Assert.*;

/**
 * Created by zhanglulu on 2018/3/6.
 */
@RunWith(AndroidJUnit4.class)
public class TestConfigureActivityTest {

    @Rule
    public ActivityTestRule<TestConfigureActivity> mRule =
            new ActivityTestRule<TestConfigureActivity>(TestConfigureActivity.class){
                @Override
                protected void beforeActivityLaunched() {
                    super.beforeActivityLaunched();
                    //Activity 启动前做些事情
                }

                @Override
                protected void afterActivityLaunched() {
                    super.afterActivityLaunched();
                    //Activity 启动后做些事情
                }
            };

    @Test
    public void useAppContext() throws Exception{
        TestConfigureActivity activity = mRule.getActivity();
        activity.configureActivity("https://testurl");
        //do more
    }

    @Test
    public void navigate() {
        onView(withText("Next")).perform(click());
        Activity activity = getActivityInstance();
        boolean b = (activity instanceof SecondActivity);
        assertTrue(b);
        // do more
    }

    public Activity getActivityInstance() {
        final Activity[] activity = new Activity[1];
        InstrumentationRegistry.getInstrumentation().runOnMainSync(() -> {
            Activity currentActivity = null;
            Collection resumedActivities =
                    ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
            if (resumedActivities.iterator().hasNext()){
                currentActivity = (Activity) resumedActivities.iterator ().next();
                activity[0] = currentActivity;
            }
        });
        return activity[0];
    }

}