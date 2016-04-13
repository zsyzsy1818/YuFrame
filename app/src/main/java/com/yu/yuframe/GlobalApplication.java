package com.yu.yuframe;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Yu on 2016/4/13.
 */
public class GlobalApplication extends Application {
    private static GlobalApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化shareSdk
        ShareSDK.initSDK(this);

        //初始化JPush
        JPushInterface.setDebugMode(true);//开启debug模式
        JPushInterface.init(this);
    }

    public static GlobalApplication getApp() {
        return app;
    }


}
