package com.yu.yuframe.test;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.yu.yuframe.R;
import com.yu.yuframe.adapter.MyAdapter;
import com.yu.yuframe.bean.test.App;
import com.yu.yuframe.bean.test.Book;
import com.yu.yuframe.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yu on 2016/4/17.
 * Email:zhaoshiyu900310@163.com
 *  MyAdapter
 */
public class MyAdapter_ListView_Test extends BaseActivity {

    private Context mContext;
    private ListView list_book;
    private ListView list_app;

    private MyAdapter<App> myAdapter1 = null;
    private MyAdapter<Book> myAdapter2 = null;
    private List<App> mData1 = null;
    private List<Book> mData2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_myadapter_main);
        mContext = MyAdapter_ListView_Test.this;
        init();

    }

    private void init() {

        list_book = (ListView) findViewById(R.id.test_myadapter_listview_list_book);
        list_app = (ListView) findViewById(R.id.test_myadapter_listview_list_app);

        //数据初始化
        loadData();


        //Adapter初始化
        myAdapter1 = new MyAdapter<App>((ArrayList) mData1, R.layout.test_myadapter_listview_item_one) {
            @Override
            public void bindView(ViewHolder holder, App obj) {
                holder.setImageResource(R.id.test_myadapter_listview_item_one_img_icon, obj.getaIcon());
                holder.setText(R.id.test_myadapter_listview_item_one_txt_aname, obj.getaName());
            }
        };
        myAdapter2 = new MyAdapter<Book>((ArrayList) mData2, R.layout.test_myadapter_listview_item_two) {
            @Override
            public void bindView(ViewHolder holder, Book obj) {
                holder.setText(R.id.test_myadapter_listview_item_two_txt_bname, obj.getbName());
                holder.setText(R.id.test_myadapter_listview_item_two_txt_bauthor, obj.getbAuthor());
            }
        };

        //ListView设置下Adapter：
        list_book.setAdapter(myAdapter2);
        list_app.setAdapter(myAdapter1);

    }

    //数据初始化
    private void loadData() {
        mData1 = new ArrayList<>();
        mData1.add(new App(R.mipmap.test_myadapter_listview_iv_icon_baidu, "百度"));
        mData1.add(new App(R.mipmap.test_myadapter_listview_iv_icon_douban, "豆瓣"));
        mData1.add(new App(R.mipmap.test_myadapter_listview_iv_icon_zhifubao, "支付宝"));

        mData2 = new ArrayList<>();
        mData2.add(new Book("《第一行代码Android》", "郭霖"));
        mData2.add(new Book("《Android群英传》", "徐宜生"));
        mData2.add(new Book("《Android开发艺术探索》", "任玉刚"));
    }


}
