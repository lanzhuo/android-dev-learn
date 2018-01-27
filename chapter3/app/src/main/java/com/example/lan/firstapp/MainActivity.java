package com.example.lan.firstapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnOk;
    EditText txtMsg;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        btnOk = (Button)findViewById(R.id.btn_Ok);
        txtMsg = (EditText)findViewById(R.id.et_entry);
        String msg = loadDataFromFile();
        txtMsg.setText(msg);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String msg = txtMsg.getText().toString();
                intent.putExtra("msg", msg);
                startActivity(intent);
            }
        });

        Button btnTest1 = (Button)findViewById(R.id.btn_test1);
        btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
        Button btnTest2 = (Button)findViewById(R.id.btn_test2);
        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                Uri smsUrl = Uri.parse("smsto:"+"10086");
                intent.setData(smsUrl);
                intent.putExtra("sms_body", "这里是短信内容");
                startActivity(intent);
            }
        });
        Button btnStartWeixin = (Button)findViewById(R.id.btn_start_weixin);
        btnStartWeixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Enter Weixin onClick.");
                if (!isExistWeixin(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, "weixin is not exist.", Toast.LENGTH_SHORT);
                    return ;
                }
                Log.d("MainActivity", "Enter Weixin onClick 1.");
//                Intent intent = new Intent();
//                ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LanucherUI");
//                intent.setAction(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setComponent(cmp);
//                startActivityForResult(intent, 0);
                startActivity(getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String content = txtMsg.getText().toString();
        saveDataToFile(content);
    }

    private void saveDataToFile(String content) {
       FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String loadDataFromFile() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return content.toString();
    }

    private boolean isExistWeixin(Context context) {
        final PackageManager packageMgr = context.getPackageManager();
        List<PackageInfo> pkgInfos = packageMgr.getInstalledPackages(0);
        if (pkgInfos != null) {
            for (int i = 0; i < pkgInfos.size(); ++i) {
                String pn = pkgInfos.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }
}
