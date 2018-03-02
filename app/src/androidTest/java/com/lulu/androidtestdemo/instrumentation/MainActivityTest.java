package com.lulu.androidtestdemo.instrumentation;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.lulu.androidtestdemo.MainActivity;
import com.lulu.androidtestdemo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private static final String TAG = "MainActivityTest";
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void ensureListViewIsPresent() throws Exception {
//        MainActivity activity = rule.getActivity();
//        View viewById = activity.findViewById(R.id.listview);
//        assertThat(viewById,notNullValue());
//        assertThat(viewById, instanceOf(ListView.class));
//        ListView listView = (ListView) viewById;
//        ListAdapter adapter = listView.getAdapter();
//        assertThat(adapter, instanceOf(ArrayAdapter.class));
//        assertThat(adapter.getCount(), is(5));
    }
}
