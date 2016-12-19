package com.example.lenovo.inequalitysign.view;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.ui.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
    private View view;
    private Button btn;
    private LinearLayout ll;
    private LinearLayout llL;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.mypageB1:
                    //调到登陆界面 ,图片下面的字体改变成推出当前账号

                    Intent i = new Intent();
                    i.setClass(getActivity().getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    btn.setText("推出当前账号");
                    break;
                case R.id.mypageB2:
                    //如果 没登陆 调到登陆界面，登陆之后可以查看记录
                    Intent intent = new Intent();
                    intent.setClass(getActivity().getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.mypageB3:
                    //如果 没登陆 调到登陆界面，登陆之后可以设置个人资料
                    Intent intent1 = new Intent();
                    intent1.setClass(getActivity().getApplicationContext(), LoginActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();
        setOnClick();
    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        ll.setOnClickListener(mListener);
        llL.setOnClickListener(mListener);
    }

    private void findView() {
        btn = (Button)view.findViewById(R.id.mypageB1);//登陆
        ll = (LinearLayout)view.findViewById(R.id.mypageB2);//排号记录
        llL = (LinearLayout)view.findViewById(R.id.mypageB3);//个人资料
    }
}
