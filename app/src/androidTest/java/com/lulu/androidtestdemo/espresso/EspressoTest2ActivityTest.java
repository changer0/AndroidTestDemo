package com.lulu.androidtestdemo.espresso;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.lulu.androidtestdemo.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
/**
 * Created by zhanglulu on 2018/3/6.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest2ActivityTest {

    @Rule
    public ActivityTestRule<EspressoTest2Activity> mRule =
            new ActivityTestRule<EspressoTest2Activity>(
                    EspressoTest2Activity.class, true, false);

    @Test
    public void demonstrateIntentPrep() {
        Intent intent = new Intent();
        intent.putExtra("input", "Test");
        mRule.launchActivity(intent);
        onView(withId(R.id.resultView)).check(matches(withText("Test")));
    }

    @Test
    public void buttonShouldUpdateText(){
        onView(withId(R.id.resultView)).perform(click());
        onView(withId(getResourceId("Click"))).check(matches(withText("Done")));
    }

    /**
     * 根据 id 字符串获取真实 id
     * @param idStr
     * @return
     */
    private static int getResourceId(String idStr) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(idStr, "id", packageName);
    }
}
