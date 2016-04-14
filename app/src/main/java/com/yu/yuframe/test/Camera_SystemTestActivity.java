package com.yu.yuframe.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统相机拍照
 * Created by Yu on 2016/4/14.
 * <p/>
 * 　从系统现有的相机应用中获取拍摄的视频，与获取拍摄的图片过程大致相同，但是它除了可以通过putExtra()设置MediaStore
 * .EXTRA_OUTPUT输出路径外，还可以设置其它值，这里简单介绍一下：
 * <p/>
 * MediaStore.EXTRA_OUTPUT：设置媒体文件的保存路径。
 * MediaStore.EXTRA_VIDEO_QUALITY：设置视频录制的质量，0为低质量，1为高质量。
 * MediaStore.EXTRA_DURATION_LIMIT：设置视频最大允许录制的时长，单位为毫秒。
 * MediaStore.EXTRA_SIZE_LIMIT：指定视频最大允许的尺寸，单位为byte。
 */
public class Camera_SystemTestActivity extends BaseActivity implements View
        .OnClickListener {
    private static final String TAG = "Camera_STActivity";


    //TODO 自定义路径(在下边按钮方法中改)
    private static String FILE_PATH;


    //TODO 使用系统默认图片文件夹路径(在下边按钮方法中改)
    private static String FILE_PATH_InGallery;

    private android.widget.Button testcamerasystemtestactivitybtnStartCamera;
    private android.widget.Button
            testcamerasystemtestactivitybtnStartCameraInGallery;
    private android.widget.ImageView testcamerasystemtestactivityivCameraImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_camera_systemtestactivity);
        this.testcamerasystemtestactivityivCameraImg = (ImageView)
                findViewById(R.id.test_camera_systemtestactivity_iv_CameraImg);
        this.testcamerasystemtestactivitybtnStartCameraInGallery = (Button)
                findViewById(R.id
                        .test_camera_systemtestactivity_btn_StartCameraInGallery);
        this.testcamerasystemtestactivitybtnStartCamera = (Button)
                findViewById(R.id
                        .test_camera_systemtestactivity_btn_StartCamera);
        testcamerasystemtestactivitybtnStartCamera.setOnClickListener(this);
        testcamerasystemtestactivitybtnStartCameraInGallery
                .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        File file;
        Uri uri;
        //清除ImageView缓存
        releaseImageViewResouce(testcamerasystemtestactivityivCameraImg);

        switch (v.getId()) {
            case R.id.test_camera_systemtestactivity_btn_StartCamera:
                FILE_PATH = Environment.getExternalStorageDirectory() +
                        "/syscamera.jpg";
                // 指定开启系统相机的Action
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                // 根据文件地址创建文件
                //TODO FILE_PATH  是你要将图片保存的地址
                file = new File(FILE_PATH);
                if (file.exists()) {
                    file.delete();
                }


                // 把文件地址转换成Uri格式
                uri = Uri.fromFile(file);
                // 设置系统相机拍摄照片完成后图片文件的存放地址
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);


                  /* TODO    MediaStore.EXTRA_OUTPUT：设置媒体文件的保存路径。
              TODO  MediaStore.EXTRA_VIDEO_QUALITY：设置视频录制的质量，0为低质量，1为高质量。
              TODO  MediaStore.EXTRA_DURATION_LIMIT：设置视频最大允许录制的时长，单位为毫秒。
             TODO   MediaStore.EXTRA_SIZE_LIMIT：指定视频最大允许的尺寸，单位为byte。*/
                startActivityForResult(intent, 0);
                break;
            case R.id.test_camera_systemtestactivity_btn_StartCameraInGallery:
                FILE_PATH_InGallery = Environment
                        .getExternalStoragePublicDirectory(Environment
                                .DIRECTORY_DCIM)
                        .toString() + "/Camera/" + "IMG_" + new SimpleDateFormat
                        ("yyyyMMdd_HHmmss").format
                        (new Date()) + ".jpg";
                // 指定开启系统相机的Action
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                // 根据文件地址创建文件
                //TODO FILE_PATH  是你要将图片保存的地址
                file = new File(FILE_PATH_InGallery);
                if (file.exists()) {
                    file.delete();
                }


                // 把文件地址转换成Uri格式
                uri = Uri.fromFile(file);
                // 设置系统相机拍摄照片完成后图片文件的存放地址
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                /*
                    TODO    MediaStore.EXTRA_OUTPUT：设置媒体文件的保存路径。
                    TODO    MediaStore.EXTRA_VIDEO_QUALITY：设置视频录制的质量，0为低质量，1为高质量。
                    TODO    MediaStore.EXTRA_DURATION_LIMIT：设置视频最大允许录制的时长，单位为毫秒。
                    TODO    MediaStore.EXTRA_SIZE_LIMIT：指定视频最大允许的尺寸，单位为byte。
             */
                startActivityForResult(intent, 1);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        Log.d(TAG, "系统相机拍照完成，resultCode=" + resultCode);

        if (requestCode == 0) {
            File file = new File(FILE_PATH);
            Uri uri = Uri.fromFile(file);
            testcamerasystemtestactivityivCameraImg.setImageURI(uri);
        } else if (requestCode == 1) {
            File file = new File(FILE_PATH_InGallery);
            Uri uri = Uri.fromFile(file);
            testcamerasystemtestactivityivCameraImg.setImageURI(uri);
        }
    }

    /**
     * 手动回收ImageView的图片资源
     *
     * @param imageView
     */
    public static void releaseImageViewResouce(ImageView imageView) {
        if (imageView == null) return;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override
    protected void onDestroy() {
        releaseImageViewResouce(testcamerasystemtestactivityivCameraImg);
        super.onDestroy();
    }
}
