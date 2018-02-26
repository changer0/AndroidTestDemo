package com.lulu.androidtestdemo.instrumentation;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lulu.androidtestdemo.MainActivity;
import com.lulu.androidtestdemo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.StringTokenizer;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNull.*;

/**
 * Created by zhanglulu on 2018/2/26.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private static final String TAG = "MainActivityTest";
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void ensureListViewIsPresent() throws Exception {
        MainActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.listview);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(ListView.class));
        ListView listView = (ListView) viewById;
        ListAdapter adapter = listView.getAdapter();
        assertThat(adapter, instanceOf(ArrayAdapter.class));
        assertThat(adapter.getCount(), greaterThan(2));
        Log.d(TAG, "ensureListViewIsPresent: 测试开始打印");
        for (int i = 0; i < adapter.getCount(); i++) {
            Object item = adapter.getItem(i);
            assertThat(item, instanceOf(String.class));
            Log.d(TAG, ((String) item));
        }
    }
}
