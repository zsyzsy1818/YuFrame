package com.yu.yuframe.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

/**
 * Created by Yu on 2016/4/14.
 */
public class Camera_SystemTestActivity extends BaseActivity implements View.OnClickListener{
    private android.widget.Button testcamerasystemtestactivitybuttonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_camera_systemtestactivity);
        this.testcamerasystemtestactivitybuttonId = (Button) findViewById(R
                .id.test_camera_systemtestactivity_buttonId);
    }

    @Override
    public void onClick(View v) {

    }
}
