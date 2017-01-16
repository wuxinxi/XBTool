package com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.szxb.api.jni_interface.api_interface;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Tangren_ on 2017/1/16 16:00.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class Main extends AppCompatActivity {
    @InjectView(R.id.scann)
    Button scann;
    @InjectView(R.id.print)
    Button print;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.scann, R.id.print})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scann:
                startActivity(new Intent(Main.this, MainActivity.class));
                break;
            case R.id.print:

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        api_interface.printertest();

                    }
                });
                thread.start();
                break;
        }
    }
}
