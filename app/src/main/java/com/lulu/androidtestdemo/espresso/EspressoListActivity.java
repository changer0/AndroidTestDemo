package com.lulu.androidtestdemo.espresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lulu.androidtestdemo.R;

public class EspressoListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    public static final int NUM = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_list);
        String[] strings = new String[NUM];
        for (int i = 0; i < NUM; i++) {
            strings[i] = "测试 " + i;
        }
        listView = ((ListView) findViewById(R.id.listview));
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strings));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "点击" + position, Toast.LENGTH_SHORT).show();
    }
}
