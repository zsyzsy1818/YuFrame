package com.yu.yuframe.adapter.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yu.yuframe.R;
import com.yu.yuframe.adapter.MBaseAdapter;

import java.util.List;

/**
 * Created by Yu on 2016/4/20.
 * Email:zhaoshiyu900310@163.com
 */
public class SwipeRefreshLayoutAdapter extends MBaseAdapter<String> {
    public SwipeRefreshLayoutAdapter(List<String> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView = getInflater().inflate(R.layout.test_swiperefreshlayoutactivity_item_test,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = ((ViewHolder) convertView.getTag());
        }
        //设置数据

        String item = getItem(position);

        viewHolder.textView.setText(item);


        return convertView;
    }
    class ViewHolder
    {
        private TextView textView;

        public ViewHolder(View convertView) {
            this.textView = (TextView)convertView.findViewById(R.id.test_swiperefreshlayoutactivity_item_test_textViewId);
        }
    }
}