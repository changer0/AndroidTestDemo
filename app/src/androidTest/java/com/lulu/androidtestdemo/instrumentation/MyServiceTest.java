package com.lulu.androidtestdemo.instrumentation;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lulu.androidtestdemo.MyService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zhanglulu on 2018/2/26.
 */
@RunWith(AndroidJUnit4.class)
public class MyServiceTest {

    @Rule
    public ServiceTestRule rule = new ServiceTestRule();

    @Test
    public void testStartedService() throws Exception {
        rule.startService(
                new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));
    }

    @Test
    public void testBindService() throws Exception {
        IBinder binder = rule.bindService(
                new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));
        MyService myService = ((MyService.MyLocalBinder) binder).getMyService();
        assertThat(myService.doSomethingToReturnTest(), is("Test"));
    }

}
