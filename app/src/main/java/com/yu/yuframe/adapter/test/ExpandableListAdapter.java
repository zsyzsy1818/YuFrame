package com.yu.yuframe.adapter.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.yu.yuframe.R;

import java.util.List;

/**
 * ExpandableListView的适配器
 * 1.创建一个类继承于BaseExpandableListAdapter,并实现10个抽象
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private List<List<String>> datas;
    private LayoutInflater inflater;

    public ExpandableListAdapter(List<List<String>> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    /**
     * 返回组的个数
     * @return
     */
    @Override
    public int getGroupCount() {
        return datas.size();
    }

    /**
     *对应组的组员个数
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return datas.get(groupPosition).size();
    }

    /**
     *获取一个组的所有成员
     * @param groupPosition
     * @return
     */
    @Override
    public List<String> getGroup(int groupPosition) {
        return datas.get(groupPosition);
    }

    /**
     * 获取对应组下的对应位置的数
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public String getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).get(childPosition);
    }

    /**
     * 组号
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 对应组对应位置的组员Id
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 获取组布局
     * @param groupPosition
     * @param isExpanded :是否展开
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.test_expandablelistadapter,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = ((ViewHolder) convertView.getTag());
        }

        viewHolder.textView.setTextSize(40);


        viewHolder.textView.setText("第"+groupPosition+"组");


        return convertView;
    }

    /**
     * 获取对应组的对应位置的视图
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.test_expandablelistadapter,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = ((ViewHolder) convertView.getTag());
        }

        String child = getChild(groupPosition, childPosition);

        viewHolder.textView.setTextSize(20);

        viewHolder.textView.setText(child);


        return convertView;
    }

    /**
     * 添加一个集合
     * @param dd
     */
    public void addAll(List<List<String>> dd)
    {
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    /**
     * 组员是否可点击
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public class ViewHolder
    {
        private TextView textView;

        public ViewHolder(View convertView) {
            this.textView = ((TextView) convertView.findViewById(R.id.test_expandablelistadapter_textViewId));
        }
    }
}
