package com.example.lan.customcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Lan on 2018/1/31.
 */

public class SubmitlButton extends Button {
    public SubmitlButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBackgroundResource(R.drawable.btn_submit);
        setText("提交");
        setTextSize(18);
        setTextColor(0xffffffff);
    }
}

