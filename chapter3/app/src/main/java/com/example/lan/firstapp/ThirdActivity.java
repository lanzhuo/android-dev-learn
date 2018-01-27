package com.example.lan.firstapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Lan on 2018/1/27.
 */

public class ThirdActivity extends Activity {

    private String[] mData = {
            "apple", "banana", "orange", "watermelon",
            "pear", "grape", "pineaapple", "strawberry",
            "cherry", "mango"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThirdActivity.this, android.R.layout.simple_list_item_1, mData);
        ListView list = (ListView)findViewById(R.id.lst_content);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ThirdActivity.this, mData[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
