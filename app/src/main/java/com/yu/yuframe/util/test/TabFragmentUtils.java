package com.yu.yuframe.util.test;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yu.yuframe.fragment.BaseFragment;

import java.util.List;

/**仿QQ下部TabFragment
 * Created by Administrator on 2016/4/8 0008.
 */
public class TabFragmentUtils implements RadioGroup.OnCheckedChangeListener {
    private List<BaseFragment> fragments;
    private FragmentManager fragmentManager;
    private int container;

    private LinearLayout linearLayout;
    //当前显示的页面
    private int curShowPosition=0;

    public TabFragmentUtils(RadioGroup radioGroup,int container,List<BaseFragment> fragments, FragmentManager fragmentManager,LinearLayout linearLayout) {

        this.linearLayout = linearLayout;
        this.container = container;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
        //设置radiobutton的点事件
        radioGroup.setOnCheckedChangeListener(this);
        //默认选择0 页面
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if(view.getId() == checkedId) {
                //隐藏当前页面
                fragments.get(curShowPosition).onStop();
                //显示点击页面
                if (fragments.get(i).isAdded()) {
                    //点击页面可见
                    fragments.get(i).onStart();
                } else {
                    fragmentManager.beginTransaction().add(container, fragments.get(i)).commit();
                }
                //真正的显示fragment
                showFragment(i);

                //更改文字【选中的】
                ((TextView) linearLayout.getChildAt(i)).setTextColor(Color.BLUE);

            }else
            {//没有选中的
                //更改文字【没有选中的】
                ((TextView) linearLayout.getChildAt(i)).setTextColor(Color.YELLOW);
            }
        }
    }

    private void showFragment(int index) {
        for (int i = 0; i < fragments.size(); i++) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(i == index)
            {//就是要显示的页面
                fragmentTransaction.show(fragments.get(i));
            }
            else
            {
                fragmentTransaction.hide(fragments.get(i));
            }
            fragmentTransaction.commit();
        }
        //当前显示的页面为 index
        curShowPosition = index;
    }
}
