package com.lulu.androidtestdemo.instrumentation;

import android.content.Context;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.FileOutputStream;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by zhanglulu on 2018/2/24.
 */
public class WriteConfigurationUtilTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Context context;

    @Mock
    FileOutputStream fileOutputStream;

    @Test
    public void writeShouldWriteTwiceToFileSystem() {
        try {
            when(context.openFileOutput(anyString(), anyInt())).thenReturn(fileOutputStream);
            WriteConfigurationUtil.writeConfiguration(context);
            verify(context, times(1)).openFileOutput(anyString(), anyInt());
            verify(fileOutputStream, atLeast(2)).write(any(byte[].class));

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}