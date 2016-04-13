package com.yu.yuframe.testmain;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by Yu on 2016/4/13.
 * 需要修改assets中API的KEY
 */
public class ShareSDK_Test extends BaseActivity implements
        PlatformActionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        初始化shareSdk
        //TODO 写在Gapp中这里就注释掉了,必须在setContentView 前加载
        ShareSDK.initSDK(this);
        setContentView(R.layout.test_sharesdk);

    }


    private void showShare() {

        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string
        // .app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://www.baidu.com");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://www.baidu.com");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

    /**
     * 分享
     *
     * @param view
     */
    public void shareOnClick(View view) {
        showShare();
    }

    /**
     * 第三方登录
     *
     * @param view
     */
    public void loginOnClick(View view) {
        loginDeal(new QQ(this));

    }

    public void loginDeal(Platform platform) {

        String userId = platform.getDb().getUserId();
        if (!TextUtils.isEmpty(userId)) {
            //表示已经认证过了

            //直接跳转到成功界面

        } else {

////            该用户存在该平台
////要功能不要数据
////            platform.SSOSetting(true);
//            //添加认证监听
//            platform.setPlatformActionListener(this);
//            //开始认证
//            platform.authorize();


            //要数据不要功能

            platform.setPlatformActionListener(this);
            platform.showUser(null);

        }

    }

    /**
     * @param platform 成功的回调
     * @param i        验证方式
     * @param hashMap  数据集合(当执行的验证方式为要数据不要功能时,该方法有数据,否则
     *                 该方法没数据)
     */
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object>
            hashMap) {
        Log.d("MainActivity", "info-----认证成功-------");

    }

    /**
     * 错误的回调
     *
     * @param platform
     * @param i         验证方式
     * @param throwable
     */
    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Log.d("MainActivity", "info-----onError-------");

    }

    /**
     * 点击取消的回调
     *
     * @param platform
     * @param i
     */
    @Override
    public void onCancel(Platform platform, int i) {

        Log.d("MainActivity", "info-----onCancel-------");
    }

    @Override
    protected void onDestroy() {
        //
        ShareSDK.stopSDK();
        super.onDestroy();

    }
}
