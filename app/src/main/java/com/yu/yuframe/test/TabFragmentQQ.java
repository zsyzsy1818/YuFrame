package com.yu.yuframe.test;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.yu.yuframe.R;
import com.yu.yuframe.fragment.BaseFragment;
import com.yu.yuframe.fragment.test.BlankFragment;
import com.yu.yuframe.ui.BaseActivity;
import com.yu.yuframe.util.test.TabFragmentUtils;

import java.util.ArrayList;

/**
     * Created by Yu on 2016/4/13.
     * 工具类
     * 参数一：fragments
     * 参数二：radiogroup  000
     * 参数三：fragmentManager
     * 参数四：R.id.containerId 000
     */
public class TabFragmentQQ extends BaseActivity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.test_tabfragment_activity_blank);
            LinearLayout li = (LinearLayout) findViewById(R.id.test_tabfragment_activity_blank_lienaerLayoutId);
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.test_tabfragment_activity_blank_radioGroupId);
            ArrayList<BaseFragment> fragments = new ArrayList<>();
            fragments.add(BlankFragment.newInstance("页面1"));
            fragments.add(BlankFragment.newInstance("页面2"));
            fragments.add(BlankFragment.newInstance("页面3"));
            fragments.add(BlankFragment.newInstance("页面4"));
            new TabFragmentUtils(radioGroup,R.id.test_tabfragment_activity_blank_containerId,fragments,getSupportFragmentManager(),li);
        }
}
