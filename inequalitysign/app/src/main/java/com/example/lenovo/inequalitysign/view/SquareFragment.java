package com.example.lenovo.inequalitysign.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.ui.CommentConent;
import com.example.lenovo.inequalitysign.ui.RankActivity;
import com.example.lenovo.inequalitysign.ui.SceneActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SquareFragment extends Fragment {
    private View view;
    private Button rank;
    private Button comment;
    private Button scene;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sq_rank:
                    Intent i = new Intent();
                    i.setClass(getActivity().getApplicationContext(),RankActivity.class);
                    startActivity(i);
                    break;
                case R.id.sq_comment:
                    Intent ii = new Intent();
                    ii.setClass(getActivity().getApplicationContext(), CommentConent.class);
                    startActivity(ii);
                    break;
                case R.id.sq_scene:
                    Intent intent = new Intent();
                    intent.setClass(getActivity().getApplicationContext(), SceneActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_square, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();
        setOnClick();
    }

    private void setOnClick() {
        rank.setOnClickListener(mListener);
        comment.setOnClickListener(mListener);
        scene.setOnClickListener(mListener);
    }

    private void findView() {
        rank = (Button)view.findViewById(R.id.sq_rank);//排行
        comment = (Button)view.findViewById(R.id.sq_comment);
        scene = (Button)view.findViewById(R.id.sq_scene);


    }
}
