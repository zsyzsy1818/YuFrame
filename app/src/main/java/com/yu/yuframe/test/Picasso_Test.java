package com.yu.yuframe.test;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

/**
 * Picasso_JakeWharton大神的图片加载
 * TODO  缓存自动清理(吊炸天)
 * Created by Yu on 2016/4/20.
 * Email:zhaoshiyu900310@163.com
 */
public class Picasso_Test extends BaseActivity {
    private android.widget.ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_picasso_activity);
        this.imageView = (ImageView) findViewById(R.id.test_picasso_activity_imageviewId);
        //调试标签开关
//                Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);
        Picasso.with(this).load("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765" +
                ".png").into(imageView);


    }
}