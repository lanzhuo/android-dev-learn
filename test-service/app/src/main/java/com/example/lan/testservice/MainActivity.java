package com.example.lan.testservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private Intent intent;
    private MyService.MyBinder binder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (MyService.MyBinder)iBinder;
            Log.d(TAG,  String.valueOf(binder.getNum()));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button btnBind = (Button) findViewById(R.id.btn_bind);
        Button btnUnbind = (Button)findViewById(R.id.btn_unbind);
        Button btnGetNum = (Button)findViewById(R.id.btn_getnum);

        btnBind.setOnClickListener(this);
        btnUnbind.setOnClickListener(this);
        btnGetNum.setOnClickListener(this);

        intent = new Intent();
        intent.setClass(MainActivity.this, MyService.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bind:
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(serviceConnection);
                break;
            case R.id.btn_getnum:
                Log.d(TAG, String.valueOf(binder.getNum()));
                break;
            default: break;
        }
    }


}
