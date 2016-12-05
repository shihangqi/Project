package com.example.lenovo.inequalitysign.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.ui.DiningActivity;
import com.example.lenovo.inequalitysign.ui.SearchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View view;
    private ImageButton btn1;
    private ImageButton btn2;
    private Button btn3;
    private Spinner spinner;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_pd:
                    Intent i = new Intent();
                    i.setClass(getActivity().getApplicationContext(), DiningActivity.class);
                    startActivity(i);
                    break;
                case R.id.btn_sys:
                    //实现扫二维码功能
                    break;
                case R.id.btn_search:
                    //跳转到搜寻界面
                    Intent ii = new Intent();
                    ii.setClass(getActivity().getApplicationContext(), SearchActivity.class);
                    startActivity(ii);
                    break;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();
        setOnClick();
        setaddress();
    }


    private void setaddress() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity().getApplicationContext(),
                R.array.languages,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                String selected = arg0.getItemAtPosition(arg2).toString();
                System.out.println(selected);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub


            }

        });
    }
    private void setOnClick() {
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
        btn3.setOnClickListener(mListener);
    }


    private void findView() {
        btn1=(ImageButton)view.findViewById(R.id.btn_pd);
        btn2=(ImageButton)view.findViewById(R.id.btn_sys);
        btn3 = (Button)view.findViewById(R.id.btn_search);
        spinner = (Spinner)view.findViewById(R.id.spinnerid);

    }
}
