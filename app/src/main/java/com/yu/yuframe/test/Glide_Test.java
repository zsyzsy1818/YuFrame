package com.yu.yuframe.test;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

/**
 * Glide_谷歌官方图片加载
 * Created by Yu on 2016/4/20.
 * Email:zhaoshiyu900310@163.com
 */
public class Glide_Test extends BaseActivity {
    private android.widget.ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_glide_activity);
        this.imageView = (ImageView) findViewById(R.id.test_glide_activity_imageviewId);
        Glide.with(this).load("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765" +
                ".png").into(imageView);

        //TODO 清理缓存必须在其他线程中执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                //清理内存缓存
                Glide.get(getApplicationContext()).clearMemory();
                //清理硬盘缓存
                Glide.get(getApplicationContext()).clearDiskCache();

            }
        });
    }
}
