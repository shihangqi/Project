package com.example.lenovo.inequalitysign.ui;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.adapter.DiningAdapter;
import com.example.lenovo.inequalitysign.entity.Dining;
import com.example.lenovo.inequalitysign.http.Https;

import java.util.ArrayList;
import java.util.List;

public class DiningActivity extends Activity {
    private  String u = "http://10.7.88.35:8090/shop/home";
    private Button btn;
    private Button btn1;
    private Button btn2;
    DiningAdapter adapter;
    private ListView lv;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter = new DiningAdapter(DiningActivity.this,ls);
            lv.setAdapter(adapter);
        }
    };
    public List<Dining> ls= new ArrayList<Dining>();//存放餐厅列表数据
    private List<String> list = new ArrayList<>();//存放营业厅列表数据
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back1:
                    Intent i = new Intent();
                    i.setClass(DiningActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.ct:
                    //展示餐厅列表数据
                    displayDining();
                    lv.setAdapter(adapter);
                    break;
                case R.id.yyt:
                    //展示营业厅列表数据
                    displayYyt();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
        findView();
        setOnClick();

    }

    /**
     * 展示营业厅数据
     */
    private void displayYyt() {

    }


    /**
     * 展示餐厅列表
     */
    private void displayDining() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("晨晨","123");
                Https http = new Https();
                ls =http.setAndGet(u);
                Message msg = new Message();
                mHandler.sendMessage(msg);

            }
        }).start();



    }


    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
    }

    private void findView() {
        btn2=(Button)findViewById(R.id.yyt);
        btn=(Button)findViewById(R.id.back1);
        btn1 = (Button)findViewById(R.id.ct);
        lv = (ListView)findViewById(R.id.Lv);
    }
}
