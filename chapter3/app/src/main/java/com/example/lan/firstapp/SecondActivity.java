package com.example.lan.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    protected static final String TAG = "Second";
    TextView mTxtContent;
    Button   mBtnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        mBtnStop = (Button)findViewById(R.id.btn_stop);
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        mTxtContent = (TextView)findViewById(R.id.txt_first);
        //Log.i(TAG, msg);
        mTxtContent.setText(msg);


    }
}
