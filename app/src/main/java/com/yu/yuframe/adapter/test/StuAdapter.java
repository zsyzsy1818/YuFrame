package com.yu.yuframe.adapter.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yu.yuframe.R;
import com.yu.yuframe.adapter.MyBaseAdapter;
import com.yu.yuframe.bean.test.StudentTest;

import java.util.List;

/**
 * Created by Yu on 2015/12/18 0018.
 * 演示继承Adapter用的
 */
public class StuAdapter extends MyBaseAdapter<StudentTest,StuAdapter.ViewHoler> {
    public StuAdapter(List<StudentTest> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected void onBindViewHolder(StudentTest studentTest, int position, ViewHoler viewHolder) {
        viewHolder.name.setText(studentTest.getName());
        viewHolder.phone.setText(studentTest.getPhone());
    }
    //初始化ViewHolder
    @Override
    protected ViewHoler onCreatViewHolder(LayoutInflater inflater) {
        return new ViewHoler(inflater.inflate(R.layout.test_stuadapter_item_listview,null));
    }

    public static class ViewHoler extends MyBaseAdapter.VHolder
    {
        TextView name,phone;
        public ViewHoler(View view) {
            super(view);
            name= ((TextView) view.findViewById(R.id.nameId));
            phone= ((TextView) view.findViewById(R.id.phoneId));
        }
    }

}
