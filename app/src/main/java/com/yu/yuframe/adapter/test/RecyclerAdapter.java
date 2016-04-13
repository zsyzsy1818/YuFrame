package com.yu.yuframe.adapter.test;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yu.yuframe.R;

import java.util.List;

/**Created by Yu on 2016/4/13.
 * 1.创建一个类，并继承ReyclerView.Adapter<>
 * 2.给这个适配器创建一个内部类，并继承RecyclerView.ViewHolder,并且提供一个有参数的构造方法
 * 3.将这个ViewHolder内部类填充在适配器类的泛型中，并且实现三个抽象方法
 * <p/>
 * item的点击事件
 * 1.创建一个接口,并写入一个方法 onItemClick（int position,View view）;
 * 2.声明这个接口，并通过set或者构造方法将其实例化
 * 3.在ViewHolder中，给itemView设置单击事件在单击事件方法中填入 itemClick.onItemClick(getLayoutPostion(),v);
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ItemClickListener itemClickListener;
    private List<String> datas;
    private LayoutInflater inflater;

    public RecyclerAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    public RecyclerAdapter(List<String> datas, Context context,
                           ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    /**
     * 实例化ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.test_recycleradapter_item, null));
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int height = holder.textView.getHeight();

        int x = (int) (Math.random() * 2);

        holder.textView.setHeight(height + x == 0 ? height + (int) (Math.random() * 81 + 50) :
                height);

        holder.textView.setText(datas.get(position));
    }

    /**
     * 返回数据源的条目
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 添加一个集合
     */
    public void addAll(List<String> dd) {
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    /**
     * 删除item项
     */
    public void deleteByIndex(int position) {
        datas.remove(position);
        //带有动画的删除
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View
            .OnLongClickListener {
        private TextView textView;

        public ViewHolder(View itemView) {
            //注意：一定不能删除这句
            super(itemView);
            textView = ((TextView) itemView.findViewById(R.id.test_recycleradapter_item_textViewId));
            /**
             * 设置itemView的单击事件
             */
            itemView.setOnClickListener(this);

            /**
             * 设置itemView的长按事件
             */
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(getLayoutPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onLongItemClick(getLayoutPosition(), v);
            return true;
        }
    }

    /**
     * RecyclerView的item的点击事件
     */
    public interface ItemClickListener {
        public void onItemClick(int position, View view);

        public void onLongItemClick(int position, View view);
    }

}

