package com.example.lenovo.inequalitysign.entity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Lenovo on 2016/11/29.
 */
public class rankContent extends Fragment{
    private View view;
    private LinearLayout ll_r;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.square_diningrank,container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll_r = (LinearLayout)view.findViewById(R.id.rank_content);
    }
}
