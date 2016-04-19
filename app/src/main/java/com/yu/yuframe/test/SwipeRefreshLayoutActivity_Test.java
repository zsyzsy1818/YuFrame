package com.yu.yuframe.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ListView;

import com.yu.yuframe.R;
import com.yu.yuframe.adapter.test.SwipeRefreshLayoutAdapter;
import com.yu.yuframe.ui.BaseActivity;

import java.util.ArrayList;

/**
 * Created by Yu on 2016/4/20.
 * Email:zhaoshiyu900310@163.com
 *
 * 刷新布局SwipeRefreshLayout
 * 1.支持所有的控件[listView,gridView,ScrollView,recyclerView...]
 * 2.设置刷新监听
 * swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener(){onRefresh(){
 *     //1.清空数据源
 *     //2.加载新的数据
 * }})
 * 3.加载数据完成之后，隐藏刷新进度
 *  swipefreshLayout.setRefreshing(false);
 */
public class SwipeRefreshLayoutActivity_Test extends BaseActivity{
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SwipeRefreshLayoutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_swiperefreshlayoutactivity_test);
        listView = ((ListView) findViewById(R.id.test_swiperefreshlayoutactivity_test_listViewId));
        swipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.test_swiperefreshlayoutactivity_test_swipeRefreshLayoutId));

        adapter = new SwipeRefreshLayoutAdapter(new ArrayList<String>(),this);

        listView.setAdapter(adapter);

        Log.i("infp", "sdfadf");

        loadData();


        //设置刷新样式
        swipeRefreshLayout.setColorSchemeColors(new int[]{Color.RED,Color.GREEN,Color.BLUE});

        //设置刷新监听[只有下拉刷新]
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //清空数据源
                adapter.clear();
                //加载新的数据
                loadData();
            }
        });
    }

    private void loadData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("item:"+i);
        }
        adapter.addAll(datas);
        //隐藏刷新进度
        swipeRefreshLayout.setRefreshing(false);
    }
}