package com.yu.yuframe.fragment.test;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yu.yuframe.R;
import com.yu.yuframe.fragment.BaseFragment;


/**
 * 仿QQ下部TabFragment
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String text) {

        Bundle args = new Bundle();

        args.putString("text",text);

        BlankFragment fragment = new BlankFragment();

        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_tabfragment_fragment_blank, container, false);
        TextView textView = (TextView) view.findViewById(R.id.test_tabfragment_fragment_blank_textViewId);
        textView.setText(getArguments().getString("text"));
        return view;
    }


}
