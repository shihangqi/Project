package com.example.lenovo.inequalitysign.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.inequalitysign.scene;

public class SquareFragment extends Fragment {

    private View view;
    private LinearLayout ll;
    private Button Bt_rank;
    private Button Bt_comment;
    private Button Bt_scene;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_square,container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll=(LinearLayout)view.findViewById(R.id.square_content);

        //排行页面调转
        Bt_rank = (Button)view.findViewById(R.id.sq_rank);
        Bt_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ranking.class);
                startActivity(intent);
            }
        });
        //评论页面跳转
        Bt_comment = (Button)view.findViewById(R.id.sq_comment);
        Bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(),comment.class);
                startActivity(intent2);
            }
        });
        //实景页面跳转
        Bt_scene = (Button)view.findViewById(R.id.sq_scene);
        Bt_scene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity(),scene.class);
                startActivity(intent3);
            }
        });
    }
}
