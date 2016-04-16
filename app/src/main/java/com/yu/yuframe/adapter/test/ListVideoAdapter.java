package com.yu.yuframe.adapter.test;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.yu.yuframe.GlobalApplication;
import com.yu.yuframe.R;
import com.yu.yuframe.adapter.MBaseAdapter;
import com.yu.yuframe.bean.test.QsVideoEntity;
import com.yu.yuframe.uri.test.MyUri;

import java.io.IOException;
import java.util.List;

/**
 * Created by Yu on 2016/4/16.
 * Email:zhaoshiyu900310@163.com
 */
public class ListVideoAdapter extends MBaseAdapter<QsVideoEntity.ItemsEntity> implements MediaPlayer
        .OnPreparedListener, MediaPlayer.OnCompletionListener {
    private MediaPlayer player;
    private int currentPosition;
    private String currentUrl;
    private Context context;
    ViewHolder viewHolder;
    public ListVideoAdapter(List<QsVideoEntity.ItemsEntity> datas, Context context) {
        super(datas, context);
        this.context = context;
        player = new MediaPlayer();
        //设置准备数据监听
        player.setOnPreparedListener(this);
        //设置完成播放监听
        player.setOnCompletionListener(this);

    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.listvideo_activity_item_qsvideo, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = ((ViewHolder) convertView.getTag());
        }
        //设置内容
        QsVideoEntity.ItemsEntity item = getItem(position);

        ViewGroup.LayoutParams layoutParams = viewHolder.surfaceView.getLayoutParams();

        layoutParams.width = item.getPic_size().get(0);
        layoutParams.height = item.getPic_size().get(1);

        viewHolder.surfaceView.setLayoutParams(layoutParams);
        //告诉父布局，重新布局，或者排版
        viewHolder.surfaceView.requestLayout();

        //设置文字
        if (item.getContent() != null) {
            viewHolder.content.setText(item.getContent());
        }

        if (item.getUser() != null && item.getUser().getLogin() != null) {
            viewHolder.loginName.setText(item.getUser().getLogin());
        }

        //设置图片
        if (item.getUser() != null && item.getUser().getIcon() != null) {
            String icon = String.format(MyUri.URL_USER_ICON, item.getUser().getId() / 10000, item.getUser().getId(),
                    item.getUser().getIcon());
            //实例化ImageListener
            ImageLoader.ImageListener imageListener = GlobalApplication.getApp().getImageLoader().getImageListener
                    (viewHolder.thumb, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
            //加载显示图片
            GlobalApplication.getApp().getImageLoader().get(icon, imageListener);
        }

        if (item.getPic_url() != null) {
            //实例化ImageListener
            ImageLoader.ImageListener imageListener = GlobalApplication.getApp().getImageLoader().getImageListener
                    (viewHolder.pic, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
            //加载显示图片
            GlobalApplication.getApp().getImageLoader().get(item.getPic_url(), imageListener);
        }

        //当前播放的postion滚出屏幕之后，停止播放
        if (viewHolder.surfaceView.getTag() != null) {
            int old = (int) viewHolder.surfaceView.getTag();

            if (old == currentPosition && old != position) {
                //暂停播放
                if (player.isPlaying()) {
                    player.stop();
                    currentPosition = -1;
                    currentUrl = null;
                }
            }
        }


        //设置标记，便于播放
        viewHolder.pic.setTag(position);
        viewHolder.surfaceView.setTag(position);

        if (currentPosition == position) {
            if (item.getLow_url().equals(currentUrl)) {
                //隐藏图片
                viewHolder.surfaceView.setVisibility(View.VISIBLE);
                viewHolder.pic.setVisibility(View.INVISIBLE);

                if (player.isPlaying()) {
                    player.stop();
                }
                //清空之前所有的配置
                player.reset();
                try {
                    player.setDataSource(context, android.net.Uri.parse(currentUrl));

                    //设置展示平台
                    player.setDisplay(viewHolder.surfaceView.getHolder());

                    player.prepareAsync();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else {
            //显示图片
            viewHolder.surfaceView.setVisibility(View.INVISIBLE);
            viewHolder.pic.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    /**
     * 准备数据的回调方法
     *
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    /**
     * 完成播放的方法
     *
     * @param mp
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        currentPosition = -1;
        currentUrl = null;

        //强制刷新
        notifyDataSetChanged();
    }

    class ViewHolder implements View.OnClickListener {
        private TextView loginName, content;
        private ImageView thumb, pic;
        private SurfaceView surfaceView;

        public ViewHolder(View convertView) {
            loginName = ((TextView) convertView.findViewById(R.id.listvideo_activity_item_qsvideo_loginNameId));
            content = ((TextView) convertView.findViewById(R.id.listvideo_activity_item_qsvideo_contentId));
            thumb = ((ImageView) convertView.findViewById(R.id.listvideo_activity_item_qsvideo_thumbId));
            pic = ((ImageView) convertView.findViewById(R.id.listvideo_activity_item_qsvideo_picId));
            surfaceView = ((SurfaceView) convertView.findViewById(R.id.listvideo_activity_item_qsvideo_surfaceViewId));
            //点击没个item来播放视频
            pic.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            //点击完图片之后，隐藏
            v.setVisibility(View.INVISIBLE);

            if (v.getTag() != null) {
                if (player.isPlaying()) {
                    player.stop();
                }

                int pos = (int) v.getTag();
                //设置当前播放位置
                currentPosition = pos;
                Log.d("ViewHolder", "currentPosition:" + currentPosition);
                //设置当前播放的url地址
                currentUrl = getItem(pos).getLow_url();

                Log.d("ViewHolder", "currentUrl:" +currentUrl);
                notifyDataSetChanged();
            }
        }
    }
}

