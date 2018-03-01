package com.lulu.androidtestdemo.instrumentation;

import android.net.Uri;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;
import android.test.mock.MockContentResolver;

import com.lulu.androidtestdemo.BookProvider;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by zhanglulu on 2018/2/27.
 */

@RunWith(AndroidJUnit4.class)
public class BookProviderTest extends ProviderTestCase2<BookProvider>{

    private MockContentResolver mMockResolver;


    public BookProviderTest() {
        super(BookProvider.class, BookProvider.AUTHORITY);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMockResolver = getMockContentResolver();
        mMockResolver.addProvider(BookProvider.AUTHORITY, BookProvider.class.newInstance());
    }



    @Test
    public void testQuery() {
        mMockResolver.query(Uri.parse(BookProvider.AUTHORITY), null, null, null, null);
    }


}
