package com.yu.yuframe.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * JPush极光推送,
 * ***必须在app  build.gradle中加入动态库
 * Created by Yu on 2016/4/13.
 */


public class JPushActivity_Test extends BaseActivity implements View
        .OnClickListener {

    private android.widget.EditText editId;
    private android.widget.Button buttonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_jpush_main);
        this.buttonId = (Button) findViewById(R.id.buttonId);
        this.editId = (EditText) findViewById(R.id.editId);
        buttonId.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    /**
     * 设置别名,指定推送
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonId:
                String alias = editId.getText().toString();
                JPushInterface.setAlias(this, alias, null);
                break;
        }
    }
}
