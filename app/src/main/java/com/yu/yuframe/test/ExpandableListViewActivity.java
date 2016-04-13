package com.yu.yuframe.test;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.yu.yuframe.R;
import com.yu.yuframe.adapter.test.ExpandableListAdapter;
import com.yu.yuframe.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * listview组合多级菜单
 * Created by Yu on 2016/4/13.
 */
public class ExpandableListViewActivity extends BaseActivity {
    private ExpandableListView listViews;
    private ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_expandablelistviewactivity);
        listViews = ((ExpandableListView) findViewById(R.id
                .test_expandablelistviewactivity_listViewsId));
        //实例化适配器
        adapter = new ExpandableListAdapter(new ArrayList<List<String>>(),
                this);
        //设置适配器
        listViews.setAdapter(adapter);
        //加载数据
        loadData();

    }

    private void loadData() {
        ArrayList<List<String>> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<String> dd = new ArrayList<>();
            for (int j = 0; j < (int) (Math.random() * 10 + 1); j++) {
                dd.add("group:" + i + "\t" + "item:" + j);
            }
            datas.add(dd);
        }
        adapter.addAll(datas);
    }
}
