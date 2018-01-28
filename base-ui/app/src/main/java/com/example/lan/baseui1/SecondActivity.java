package com.example.lan.baseui1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lan on 2018/1/27.
 */

public class SecondActivity extends Activity implements View.OnClickListener{

    SeekBar mSeekBar;
    TextView mTextViewValue;
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mSeekBar = (SeekBar)findViewById(R.id.seek_bar_my);
        mTextViewValue = (TextView)findViewById(R.id.textview_value);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("SecondActivity", i + "");
                mTextViewValue.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Button btnIncrease = (Button)findViewById(R.id.btn_add);
        Button btnDescrease = (Button)findViewById(R.id.btn_sub);
        btnIncrease.setOnClickListener(this);
        btnDescrease.setOnClickListener(this);

        DatePicker datePicker = (DatePicker)findViewById(R.id.my_date_picker);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker dp = (DatePicker)view;
                Log.d("SecondActivity", "Year: " + dp.getYear() + " Month: " + dp.getMonth() + " Day: " + dp.getDayOfMonth());
            }
        });
        Button btnEnterThird = (Button)findViewById(R.id.btn_enter_third_act);
        btnEnterThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("SecondActivity", "onBackPressed");
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                mProgressBar.setProgress(mProgressBar.getProgress() + 1);
                break;
            case R.id.btn_sub:
                mProgressBar.setProgress(mProgressBar.getProgress() - 1);
                break;
        }
    }
}
