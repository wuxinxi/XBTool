package com.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
import com.szxb.zxing.activity.CaptureFragment;
import com.szxb.zxing.activity.CodeUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @InjectView(R.id.jianyi)
    TextView jianyi;
    @InjectView(R.id.light)
    Button light;
    @InjectView(R.id.close)
    Button close;
    @InjectView(R.id.activity_second)
    FrameLayout activitySecond;
    private CaptureFragment captureFragment;
    private boolean iscontinu = false;
    private boolean islight = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scann);
        ButterKnife.inject(this);

        captureFragment = new CaptureFragment();
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        captureFragment.setContinuScann(true);//设置连续扫描
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();

    }

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            TSnackbar.make(findViewById(android.R.id.content), result, TSnackbar.LENGTH_LONG).show();
        }

        @Override
        public void onAnalyzeFailed() {
            TSnackbar.make(findViewById(android.R.id.content), "扫码失败", TSnackbar.LENGTH_LONG).show();
        }
    };

    @OnClick({R.id.light, R.id.close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.light:
                if (islight) {
                    light.setText("开灯");
                    CodeUtils.isLightEnable(false);
                    islight = false;

                } else {
                    light.setText("关灯");
                    CodeUtils.isLightEnable(true);
                    islight = true;
                }
                break;
            case R.id.close:
                finish();
                break;
        }
    }
}
