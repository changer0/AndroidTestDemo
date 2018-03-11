package com.lulu.androidtestdemo.espresso.custom_matcher;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.core.internal.deps.dagger.internal.Preconditions.checkNotNull;
import static android.support.test.espresso.core.internal.deps.guava.base.Preconditions.checkArgument;
import static org.hamcrest.core.Is.is;

/**
 * Created by lulu on 2018/3/10.
 * 自定义的 View 匹配器
 */
public class Matchers {
    public static Matcher<View> withItemHint(final String itemHintText) {
        checkArgument(!(itemHintText.equals(null)));
        return withItemHint(is(itemHintText));
    }
    public static Matcher<View> withItemHint(final Matcher<String> matcherText) {
        // 如果传入非法的 matcher 需提前处理
        checkNotNull(matcherText);
        return new BoundedMatcher<View, EditText>(EditText.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("该 EditText 的 Hint 为: " + matcherText);
            }

            @Override
            protected boolean matchesSafely(EditText item) {
                return matcherText.matches(item.getHint().toString());
            }
        };
    }
}
