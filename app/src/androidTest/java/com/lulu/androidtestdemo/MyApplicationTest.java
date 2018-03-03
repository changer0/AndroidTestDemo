package com.lulu.androidtestdemo;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.test.ApplicationTestCase;
import android.test.MoreAsserts;
/**
 * Created by lulu on 2018/3/3.
 */
public class MyApplicationTest extends ApplicationTestCase{

    private Application application;

    public MyApplicationTest() {
        super(MyApplication.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        createApplication();
        application = getApplication();
    }

    public void testCorrectVersion() throws Exception {
        PackageInfo info = application.getPackageManager().
                getPackageInfo(application.getPackageName(), 0);
        assertNotNull(info);
        MoreAsserts.assertMatchesRegex("\\d\\.\\d", info.versionName);
    }
}