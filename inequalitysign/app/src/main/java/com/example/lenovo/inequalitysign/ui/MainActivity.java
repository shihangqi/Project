package com.example.lenovo.inequalitysign.ui;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.inequalitysign.R;

import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.view.HomeFragment;
import com.example.lenovo.inequalitysign.view.MineFragment;
import com.example.lenovo.inequalitysign.view.NearbyFragment;
import com.example.lenovo.inequalitysign.view.SquareFragment;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private HomeFragment hf;
    private MineFragment mf;
    private NearbyFragment nf;
    private SquareFragment sf;
    private LinearLayout ll;

    private View.OnClickListener mListener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            android.app.FragmentManager fm = getFragmentManager();
//            FragmentTransaction ft =fm.beginTransaction();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            switch (view.getId()){
                case R.id.btn_sy:
                  if(hf == null){
                      hf = new HomeFragment();
                  }
                    ft.replace(R.id.container,hf);
                    break;
                case R.id.btn_gc://广场
                    if(sf ==null){
                        sf = new SquareFragment();

                    }
                    ft.replace(R.id.container,sf);
                    break;
                case R.id.btn_fj:
                    if(nf == null){
                        nf = new NearbyFragment();
                    }
                    ft.replace(R.id.container,nf);
                    break;
                case R.id.btn_wd:
                    if(mf == null){
                        mf = new MineFragment();
                    }
                    ft.replace(R.id.container,mf);
                    break;
            }//switch
            ft.commit();
            ll.invalidate();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findView();
        setOnClick();
        switch(Utils.flag){//实现从Fragment跳转到Fragment
            case 1:
                setDefaultPage();
                break;
            case 2:
                setSquare();
                break;
            case 3:
                setNear();
                break;
            case 4:
                setMine();
        }

    }

    private void init() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d("mytoken:",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d("myerror:","123456");
            }
        });

    }

    private void setMine() {
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        if (mf == null) {
            mf = new MineFragment();
        }

        ft.replace(R.id.container,mf);
        ft.commit();
        ll.invalidate();
    }

    private void setNear() {
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        if (nf == null) {
            nf = new NearbyFragment();
        }

        ft.replace(R.id.container,nf);
        ft.commit();
        ll.invalidate();
    }

    private void setSquare() {
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        if (sf == null) {
            sf = new SquareFragment();
        }

        ft.replace(R.id.container,sf);
        ft.commit();
        ll.invalidate();
    }

    private void setDefaultPage() {
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();
        if (hf == null) {
            hf = new HomeFragment();
        }

        ft.replace(R.id.container,hf);
        ft.commit();
        ll.invalidate();
    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
        btn3.setOnClickListener(mListener);

    }

    private void findView() {
        btn = (Button)findViewById(R.id.btn_sy);
        btn1 = (Button)findViewById(R.id.btn_gc);
        btn2 = (Button)findViewById(R.id.btn_fj);
        btn3 = (Button)findViewById(R.id.btn_wd);
        ll = (LinearLayout)findViewById(R.id.ll);
    }
}
