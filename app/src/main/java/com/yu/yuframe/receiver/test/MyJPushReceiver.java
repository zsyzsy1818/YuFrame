package com.yu.yuframe.receiver.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Yu on 2016/4/13.
 */
public class MyJPushReceiver extends BroadcastReceiver {
    private static final String TAG="";
    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         * 获取Intent中携带的服务端发送过来的消息
         */
        Bundle bundle = intent.getExtras();

        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            String s= "收到了自定义消息。消息内容是：" + bundle.getString(JPushInterface.EXTRA_MESSAGE);
            Toast.makeText(context, "" + s, Toast.LENGTH_LONG).show();
        }
    }
}
