package com.lulu.androidtestdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.lulu.androidtestdemo.instrumentation.MyContentProvider;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTest";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onInsertClick(View view) {
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.TEST_TABLE_COL_CONTENT, "测试数据" + new Random(System.currentTimeMillis()).nextInt());
        getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
    }

    public void onQueryClick(View view) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex(MyContentProvider.TEST_TABLE_COL_CONTENT));
                    Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        }
    }

}
