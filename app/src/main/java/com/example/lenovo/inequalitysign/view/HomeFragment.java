package com.example.lenovo.inequalitysign.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/11/5 0005.
 */
public class HomeFragment extends Fragment {
    int[] imageIds = new int[]
            {
                    R.drawable.lza,
                    R.drawable.lzb,
                    R.drawable.lza,
                    R.drawable.lza
            };
    int currentImageId = 0;
    private View view;
    private Button btn1;
    private Button btn2;
    private LinearLayout ll5;
    private LinearLayout ll6;
    private LinearLayout ll7;
    private LinearLayout ll8;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_home, container, false);

        return view;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        final ImageView lz = (ImageView)view.findViewById(R.id.lz);

        final Handler myHandler = new Handler() {
            @Override
            public  void handleMessage(Message msg)
            {
                if(msg.what==0x1233)
                {
                    lz.setImageResource(imageIds[currentImageId++]);
                    if(currentImageId>=4)
                    {
                        currentImageId=0;
                    }
                }
            }
        };

        Button btn1=(Button)view.findViewById(R.id.btn_pd);
        Button btn2=(Button)view.findViewById(R.id.btn_sys);
        LinearLayout ll5=(LinearLayout)view.findViewById(R.id.ll1) ;
        LinearLayout ll6=(LinearLayout)view.findViewById(R.id.ll2) ;
        LinearLayout ll7=(LinearLayout)view.findViewById(R.id.ll3) ;
        LinearLayout ll8=(LinearLayout)view.findViewById(R.id.ll4) ;
        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity().getApplication(),NameActivity.class);
                startActivity(i);
            }
        });
        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 =new Intent(getActivity().getApplication(),NameActivity.class);
                startActivity(i1);
            }
        });
        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 =new Intent(getActivity().getApplication(),NameActivity.class);
                startActivity(i2);
            }
        });
        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 =new Intent(getActivity().getApplication(),NameActivity.class);
                startActivity(i3);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),ListActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ListActivity.class);
                startActivity(intent);
            }
        });




        new Timer().schedule(new TimerTask()
        {
            @Override
            public  void run()
            {
                Message msg=new Message();
                Log.e("ss","test"+msg.toString());
                msg.what=0x1233;
                myHandler.sendMessage(msg);
            }
        },0,2000);


    }

}


