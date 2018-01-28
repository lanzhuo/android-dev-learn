package com.example.lan.baseui1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;

/**
 * Created by Lan on 2018/1/28.
 */

public class ThirdActivity extends Activity {

    String[] mData = {
            "大学一年级",
            "大学二年级",
            "大学三年级",
            "大学四年级",
            "高中一年级",
            "高中二年级",
            "高中三年级",
            "高中四年级",
            "中学一年级",
            "中学二年级",
            "中学三年级",
            "中学四年级",
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ListView listView = (ListView)findViewById(R.id.list_view_my);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThirdActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, mData);
        listView.setAdapter(adapter);

    }
}
