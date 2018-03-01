package com.lulu.androidtestdemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTest";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        listView = findViewById(R.id.listview);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                new String[]{"测试1", "测试2", "测试3", "测试4", "测试5"});
//        listView.setAdapter(arrayAdapter);

    }

    public void onChangeClick(View view) {
        Toast.makeText(this, view.getId()+"被点击了", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onChangeClick: 点击了");

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setItems(R.array.bookshelf_import_title, (dialogInterface, i) -> {
                    switch (i) {
                        //云书架
                        case 0:

                            break;
                        //导入本地书
                        case 1:

                            break;
                        default:
                            break;
                    }
                })
                .setNegativeButton("取消", (dialog1, whichButton) -> {
                }).create();
        dialog.show();
    }
}
