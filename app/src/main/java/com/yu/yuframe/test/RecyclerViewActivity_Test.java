package com.yu.yuframe.test;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.yu.yuframe.R;
import com.yu.yuframe.adapter.test.RecyclerAdapter;
import com.yu.yuframe.ui.BaseActivity;

import java.util.ArrayList;

/**
 * Created by Yu on 2016/4/13.
 */
public class RecyclerViewActivity_Test extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recyclerviewactivity);
        recyclerView = ((RecyclerView) findViewById(R.id
                .test_recyclerviewactivity_recyclerViewId));
        //固定recyclerView大小
        recyclerView.setHasFixedSize(true);
        //设置增删动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置布局管理器
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));

        adapter = new RecyclerAdapter(new ArrayList<String>(), this, new
                RecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
//                adapter.deleteByIndex(position);
            }

            @Override
            public void onLongItemClick(int position, View view) {
                adapter.deleteByIndex(position);
                Toast.makeText(getApplicationContext(), "删除了" + position + "数据",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //设置适配器
        recyclerView.setAdapter(adapter);

        //加载数据
        loadData();

    }

    private void loadData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("item:" + i);
        }
        adapter.addAll(datas);
    }
}