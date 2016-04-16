package com.yu.yuframe;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.yu.greendao.DaoMaster;
import com.yu.greendao.DaoSession;
import com.yu.yuframe.config.MyConfig;

import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Yu on 2016/4/13.
 */
public class GlobalApplication extends Application {
    private static GlobalApplication app;
    //TODO 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    private static SQLiteDatabase db;

    //Volley框架初始化:
    private RequestQueue queue;
    private ImageLoader imageLoader;

    /**
     * 创建App初始化方法
     */
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化shareSdk
        ShareSDK.initSDK(this);

        //初始化JPush
        JPushInterface.setDebugMode(true);//开启debug模式
        JPushInterface.init(this);


        getDaoSession(this);


        //初始化Volley
        initVolley();
    }

    public static GlobalApplication getApp() {
        return app;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    /**
     * 取得DaoMaster
     *
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
            // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
            // TODO 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
            // TODO 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, MyConfig.DATABASE_NAME, null);
            db = helper.getWritableDatabase();
            // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
            daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    private void initVolley() {
        //实例化请求队列
        queue = Volley.newRequestQueue(this);
        //实例化ImageLoader
        imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {

            private LruCache<String,Bitmap> lruCache = new LruCache<String,Bitmap>(10<<20){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes()*value.getHeight();
                }
            };

            /**
             * 取图片
             * @param url
             * @return
             */
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            /**
             * 存图片
             * @param url
             * @param bitmap
             */
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url,bitmap);
            }
        });
    }
    public RequestQueue getQueue() {
        return queue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
