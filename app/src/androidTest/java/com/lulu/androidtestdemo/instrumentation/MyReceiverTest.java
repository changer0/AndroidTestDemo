package com.lulu.androidtestdemo.instrumentation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import com.lulu.androidtestdemo.MyService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by zhanglulu on 2018/2/26.
 */
@RunWith(AndroidJUnit4.class)
public class MyReceiverTest {


    public MyReceiver mReceiver = new MyReceiver();

    @Mock
    public Context mContext;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testStartActivity() throws Exception{
        // prepare data for onReceive and call it
        Intent intent = new Intent(MyReceiver.TEST_RECEIVER);
        intent.putExtra("key", "01234567890");
        mReceiver.onReceive(mContext, intent);
        assertNull(mReceiver.getResultData());

        //验证Receiver的操作
        ArgumentCaptor<Intent> argument =
                ArgumentCaptor.forClass(Intent.class);
        verify(mContext, times(1)).startActivity(argument.capture());
        Intent receivedIntent = argument.getValue();
        assertNull(receivedIntent.getAction());
        assertEquals("01234567890", receivedIntent.getStringExtra("key"));
        assertTrue((receivedIntent.getFlags() &
                Intent.FLAG_ACTIVITY_NEW_TASK) != 0);
    }
}