package com.yu.yuframe.test;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

/**
 * Created by Yu on 2016/4/21.
 * Email:zhaoshiyu900310@163.com
 * 权限:<uses-permission android:name="android.permission.INTERNET"/>
 *
 */
public class Fresco_Test extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 需写在Application中初始化
        Fresco.initialize(getApplicationContext());

        setContentView(R.layout.test_fresco_activity);
        Uri uri = Uri.parse("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.test_fresco_activity_my_image_view);
        draweeView.setImageURI(uri);
    }
}
