package com.yu.yuframe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Yu on 2015/12/18 0018.
 */
public abstract class MyBaseAdapter<T,X extends MyBaseAdapter.VHolder> extends BaseAdapter {
    private List<T> datas;
    private LayoutInflater inflater;

    public MyBaseAdapter(List<T> datas,Context context) {
        this.datas = datas;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(List<T> dd)
    {
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    public void clear()
    {
        datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        X viewHolder;
        if(convertView==null)
        {
            viewHolder=onCreatViewHolder(inflater);
            convertView = viewHolder.getView();
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (X) convertView.getTag();
        }
        onBindViewHolder(datas.get(position),position,viewHolder);
        return viewHolder.getView();
    }

    protected abstract void onBindViewHolder(T t, int position, X viewHolder);


    protected abstract X onCreatViewHolder(LayoutInflater inflater);


    public static class VHolder
    {
        private View view;
        public VHolder(View view)
        {
            this.view=view;
        }

        public View getView() {
            return view;
        }
    }

}
