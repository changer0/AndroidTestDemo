package com.lulu.androidtestdemo.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.lulu.androidtestdemo.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.lulu.androidtestdemo.espresso.custom_matcher.Matchers.withItemHint;

/**
 * Created by lulu on 2018/3/10.
 * 测试自定义匹配器
 */
@RunWith(AndroidJUnit4.class)
public class TestCustomMatcher {

    @Rule
    public ActivityTestRule<EspressoTest1Activity> mRule =
            new ActivityTestRule<EspressoTest1Activity>(EspressoTest1Activity.class);

    @Test
    public void testEditHintDisplay() throws Exception {
        onView(withId(R.id.inputField)).check(matches(withItemHint("this is a hint")));
    }
}
