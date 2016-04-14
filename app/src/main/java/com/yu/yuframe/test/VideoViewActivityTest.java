package com.yu.yuframe.test;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

/**
 * 用于播放本地视频
 * Created by Yu on 2016/4/14.
 * VideoVideo实现含有系统控制条的播放器
 * 1.查找控件
 * 2.设置数据源
 * 3.实例化控制条【MediaController】
 * MediaController controller = new MediaController(context);
 * 4.设置控制条
 * 5.界面可见，播放视频
 */

public class VideoViewActivityTest extends BaseActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //隐藏状态栏
        getSupportActionBar().hide();


        //隐藏标题栏
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        setContentView(R.layout.test_videoview_activity);


        //1.查找控件
        videoView = ((VideoView) findViewById(R.id
                .test_videoview_activity_videoViewId));
        //2.设置数据源
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                getPackageName() + "/" + R.raw.test);

        videoView.setVideoURI(uri);
        //3.实例化控制条
        MediaController mediaController = new MediaController(this);
        //4.设置控制条
        videoView.setMediaController(mediaController);
    }

    //界面可见，加载显示图像
    @Override
    protected void onResume() {
        super.onResume();
        //开始播放
        videoView.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(3000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //隐藏标题栏
// Remember that you should never show the action bar if the
/* status bar is hidden, so hide that too if necessary.*/
                                View decorView = getWindow().getDecorView();
                                int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                                decorView.setSystemUiVisibility(uiOptions);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        return super.onTouchEvent(event);

    }
}
