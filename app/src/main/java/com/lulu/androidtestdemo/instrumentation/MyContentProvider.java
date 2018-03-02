package com.lulu.androidtestdemo.instrumentation;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    public static final String AUTHORITIES = "com.lulu.androidtestdemo.MyContentProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITIES + "/content");

    private SQLiteOpenHelper mDbHelper;

    public static final int CODE_TEST = 1;

    private static final UriMatcher mUriMatcher;

    static{
        mUriMatcher = new UriMatcher(0);

        // 添加 Uri的匹配规则，实现 uri 对应判断是哪个表的操作
        mUriMatcher.addURI("*", "/content", CODE_TEST);
    }


    public MyContentProvider() {
    }


    @Override
    public boolean onCreate() {
        mDbHelper = new DbHelper(getContext());
        return true;
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri ret = null;
        int code = mUriMatcher.match(uri);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        switch (code) {
            case CODE_TEST:
                long id = db.insert(TEST_TABLE_NAME, null, values);
                // 数据库添加完成之后返回的 ID，必须和 Uri参数拼接在一起，再返回
                ret = ContentUris.withAppendedId(uri, id);
                break;
        }
        db.close();
        return ret;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor ret = null;
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        int code = mUriMatcher.match(uri);
        switch (code) {
            case CODE_TEST:
                ret = db.query(TEST_TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;
        }
        return ret;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
       return 0;
    }

    public SQLiteOpenHelper getDbHelper() {
        return mDbHelper;
    }

    public static final String TEST_TABLE_NAME = "testTable";
    public static final String TEST_TABLE_COL_CONTENT = "content";


    public class DbHelper extends SQLiteOpenHelper {


        private static final String CREATE_TABLE_COST =
                "create table if not exists " + TEST_TABLE_NAME +
                        "( _id integer primary key autoincrement," +
                        TEST_TABLE_COL_CONTENT + " text" +
                        ")";

        public DbHelper(Context context) {
            super(context, "myapp", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_COST);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
