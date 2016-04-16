package com.yu.yuframe.test;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yu.yuframe.GlobalApplication;
import com.yu.yuframe.R;
import com.yu.yuframe.adapter.test.ListVideoAdapter;
import com.yu.yuframe.bean.test.QsVideoEntity;
import com.yu.yuframe.ui.BaseActivity;
import com.yu.yuframe.uri.test.MyUri;

import java.util.ArrayList;

/**
 * Created by Yu on 2016/4/16.
 * Email:zhaoshiyu900310@163.com
 */
public class ListVideoActivity_Test extends BaseActivity {
    private ListView listView;
    private ListVideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listvideo_activity_test);
        this.listView = (ListView) findViewById(R.id.listvideo_activity_test_listViewId);
        //实例化适配器
        videoAdapter = new ListVideoAdapter(new ArrayList<QsVideoEntity.ItemsEntity>(), this);
        //设置适配器
        listView.setAdapter(videoAdapter);
        //加载数据
        loadData();
    }

    private void loadData() {
        StringRequest request = new StringRequest(
                String.format(MyUri.URL_VIDEO, 1),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        QsVideoEntity qsVideoEntity = gson.fromJson(response, QsVideoEntity.class);
                        //数据添加，并刷新适配器
                        videoAdapter.addAll(qsVideoEntity.getItems());
                    }
                },
                null
        );
        //设置请求取消标记
        request.setTag("qsVideo");

        //将请求添加在请求队列
        GlobalApplication.getApp().getQueue().add(request);
    }

    //界面销毁时，取消请求
    @Override
    protected void onDestroy() {
        GlobalApplication.getApp().getQueue().cancelAll("qsVideo");
        super.onDestroy();
    }
}
