package com.lulu.androidtestdemo.instrumentation;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.test.ApplicationTestCase;
import android.test.MoreAsserts;

import com.lulu.androidtestdemo.MyApplication;

import org.junit.Test;

/**
 * Created by zhanglulu on 2018/2/26.
 */

public class ApplicationTest extends ApplicationTestCase<MyApplication> {

    public MyApplication application;

    public ApplicationTest() {
        super(MyApplication.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        application = getApplication();
    }

    @Test
    public void testCorrectVersion() throws Exception {
        PackageInfo info = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        assertNotNull(info);
        MoreAsserts.assertMatchesRegex("\\d\\.\\d", info.versionName);
    }
}
