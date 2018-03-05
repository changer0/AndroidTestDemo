package com.lulu.androidtestdemo.instrumentation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;
import android.test.mock.MockContentResolver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by zhanglulu on 2018/3/2.
 */
@RunWith(AndroidJUnit4.class)
public class MyContentProviderTest extends ProviderTestCase2<MyContentProvider>{

    public MockContentResolver mMockResolver;

    public MyContentProviderTest() {
        super(MyContentProvider.class, MyContentProvider.AUTHORITIES);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        mMockResolver = getMockContentResolver();
    }
    @Test
    public void insert() throws Exception {
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.TEST_TABLE_COL_CONTENT, "保存测试信息");
        Uri insert = mMockResolver.insert(MyContentProvider.CONTENT_URI, values);
        Cursor cursor = mMockResolver.query(MyContentProvider.CONTENT_URI,
                null, null,
                null, null);
        assertTrue(cursor.moveToNext());
        assertEquals(1, cursor.getCount());
        String testStr =
                cursor.getString(cursor.getColumnIndex(MyContentProvider.TEST_TABLE_COL_CONTENT));
        assertEquals(testStr, "保存测试信息");
    }
}