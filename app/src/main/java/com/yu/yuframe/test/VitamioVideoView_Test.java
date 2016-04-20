package com.yu.yuframe.test;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by Yu on 2016/4/20.
 * Email:zhaoshiyu900310@163.com
 */
public class VitamioVideoView_Test extends BaseActivity {
    /**
     * TODO: Set the path variable to a streaming video URL or a local media file
     * path.
     */

    boolean ifUpdate;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);

        setContentView(R.layout.test_vitamiovideoview_activity);

        playfunction();
    }
    void playfunction(){
        String path = "";
        VideoView mVideoView;
        EditText mEditText;
        mEditText = (EditText) findViewById(R.id.test_vitamiovideoview_activity_url);
        mVideoView = (VideoView) findViewById(R.id.test_vitamiovideoview_activity_surface_view);

        path="http://dlqncdn.miaopai.com/stream/MVaux41A4lkuWloBbGUGaQ__.mp4";
        if (path == "") {
            // Tell the user to provide a media file URL/path.
            Toast.makeText(VitamioVideoView_Test.this, "Please edit VideoViewDemo Activity, and set path" + " variable to " +
                    "your" +
                    " media file URL/path", Toast.LENGTH_LONG).show();
            return;
        } else {
			/*
			 * Alternatively,for streaming media you can use
			 * mVideoView.setVideoURI(Uri.parse(URLstring));
			 */
            mVideoView.setVideoPath(path);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.requestFocus();

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    // optional need Vitamio 4.0
                    mediaPlayer.setPlaybackSpeed(1.0f);
                }
            });
        }
    }
}
