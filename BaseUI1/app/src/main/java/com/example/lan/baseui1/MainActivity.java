package com.example.lan.baseui1;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    PopupWindow mPopWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button btnPopWin = (Button)findViewById(R.id.btn_pop_win);
        btnPopWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mPopWindow.showAsDropDown(view);
                mPopWindow.showAtLocation(MainActivity.this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
            }
        });
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_window, null);
        TextView tvTitle = (TextView)view.findViewById(R.id.tv_title);
        tvTitle.setText("标题");
        TextView tvMsg   = (TextView)view.findViewById(R.id.tv_msg);
        tvMsg.setText("这里是popwindow信息");
        view.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "OK click", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Cancel click", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
            }
        });
        mPopWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopWindow.setFocusable(true);
    }
}
