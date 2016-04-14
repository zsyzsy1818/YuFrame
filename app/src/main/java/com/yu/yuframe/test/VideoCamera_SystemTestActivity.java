package com.yu.yuframe.test;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统相机录像
 * Created by Yu on 2016/4/14.
 * 从系统现有的相机应用中获取拍摄的视频，与获取拍摄的图片过程大致相同，但是它除了可以通过putExtra()设置MediaStore
 * .EXTRA_OUTPUT输出路径外，还可以设置其它值，这里简单介绍一下：
 * <p>
 * MediaStore.EXTRA_OUTPUT：设置媒体文件的保存路径。
 * MediaStore.EXTRA_VIDEO_QUALITY：设置视频录制的质量，0为低质量，1为高质量。
 * MediaStore.EXTRA_DURATION_LIMIT：设置视频最大允许录制的时长，单位为毫秒。
 * MediaStore.EXTRA_SIZE_LIMIT：指定视频最大允许的尺寸，单位为byte。
 */
public class VideoCamera_SystemTestActivity extends BaseActivity implements
        View.OnClickListener {
    private android.widget.Button testvideocamerasystemtestactivitybuttonId;
    private static final String TAG = "VideoCamera_STActivity";
    private Uri uri;


    //TODO 使用系统默认图片文件夹路径(在下边按钮方法中改)
    private static String FILE_PATH_VIDEO;
    private android.widget.VideoView
            testvideocamerasystemtestactivityvideoviewId;
    private Button testvideocamerasystemtestactivitybuttonplayId;
    private android.widget.LinearLayout
            testvideocamerasystemtestactivitylayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏状态栏
        getSupportActionBar().hide();

        setContentView(R.layout.test_videocamera_systemtestactivity);
        this.testvideocamerasystemtestactivitylayoutId = (LinearLayout)
                findViewById(R.id.test_videocamera_systemtestactivity_layoutId);
        this.testvideocamerasystemtestactivitybuttonplayId = (Button)
                findViewById(R.id
                        .test_videocamera_systemtestactivity_buttonplayId);
        this.testvideocamerasystemtestactivityvideoviewId = (VideoView)
                findViewById(R.id
                        .test_videocamera_systemtestactivity_videoviewId);
        this.testvideocamerasystemtestactivitybuttonId = (Button)
                findViewById(R.id.test_videocamera_systemtestactivity_buttonId);

        testvideocamerasystemtestactivitybuttonId.setOnClickListener(this);
        testvideocamerasystemtestactivitybuttonplayId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //录像按钮
            case R.id.test_videocamera_systemtestactivity_buttonId:
                FILE_PATH_VIDEO = Environment
                        .getExternalStoragePublicDirectory(Environment
                                .DIRECTORY_DCIM)
                        .toString() + "/Camera/" + "VID_" + new SimpleDateFormat
                        ("yyyyMMdd_HHmmss").format
                        (new Date()) + ".mp4";
                Intent intent = new Intent();
                intent.setAction("android.media.action.VIDEO_CAPTURE");
                intent.addCategory("android.intent.category.DEFAULT");
                File file = new File(FILE_PATH_VIDEO);
                if (file.exists()) {
                    file.delete();
                }

                uri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 1024 * 1024 * 300);
                //最大300M
             /* TODO    MediaStore.EXTRA_OUTPUT：设置媒体文件的保存路径。
              TODO  MediaStore.EXTRA_VIDEO_QUALITY：设置视频录制的质量，0为低质量，1为高质量。
              TODO  MediaStore.EXTRA_DURATION_LIMIT：设置视频最大允许录制的时长，单位为毫秒。
             TODO   MediaStore.EXTRA_SIZE_LIMIT：指定视频最大允许的尺寸，单位为byte。*/

                startActivityForResult(intent, 0);
                break;

            //播放按钮
            case R.id.test_videocamera_systemtestactivity_buttonplayId:


                if (uri != null) {
                    //开始播放隐藏背景按钮等
                    testvideocamerasystemtestactivitylayoutId
                            .setBackgroundColor(Color.BLACK);
                    testvideocamerasystemtestactivitybuttonId.setVisibility
                            (View.GONE);
                    testvideocamerasystemtestactivitybuttonplayId
                            .setVisibility(View.GONE);
                    Log.d(TAG, "uri:" + uri);

                    testvideocamerasystemtestactivityvideoviewId.setVideoURI
                            (uri);
                    //3.实例化控制条
                    MediaController mediaController = new MediaController(this);
                    //4.设置控制条
                    testvideocamerasystemtestactivityvideoviewId
                            .setMediaController(mediaController);
                    //开始播放
                    testvideocamerasystemtestactivityvideoviewId.start();

                    //播放完成显示背景
                    testvideocamerasystemtestactivityvideoviewId.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            testvideocamerasystemtestactivitylayoutId
                                    .setBackgroundColor(Color.WHITE);
                            testvideocamerasystemtestactivitybuttonId.setVisibility
                                    (View.VISIBLE);
                            testvideocamerasystemtestactivitybuttonplayId
                                    .setVisibility(View.VISIBLE);
                        }
                    });
                } else {
                    Toast.makeText(this, "请先录制视频", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        Toast.makeText(this, "拍摄完成，resultCode=" + requestCode, Toast
                .LENGTH_SHORT).show();
    }
}
