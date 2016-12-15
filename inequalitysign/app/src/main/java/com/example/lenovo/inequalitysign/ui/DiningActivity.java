package com.example.lenovo.inequalitysign.ui;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.adapter.DiningAdapter;
import com.example.lenovo.inequalitysign.entity.Dining;
import com.example.lenovo.inequalitysign.http.Httpss;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class DiningActivity extends Activity {
    private  String u = Utils.SHOP_URL+"line_dining";
    private String u1 = Utils.SHOP_URL+"line_hall";

    private Button btn;
    private Button btn1;
    private Button btn2;
    private DiningAdapter adapter;
    private ListView lv;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            adapter = new DiningAdapter(DiningActivity.this,ls);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //设置点击事件
                    Intent intent = new Intent();
                    intent.setClass(DiningActivity.this, DiningInformationActivity.class);
                    intent.putExtra("Context","DiningActivity");
                    intent.putExtra("Name",ls.get(i).getName());
                    intent.putExtra("Url",ls.get(i).getUrl());
                    intent.putExtra("Id",ls.get(i).getShop_id());

                    startActivityForResult(intent,i);
                }
            });
        }
    };
    private Handler mHandler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {//营业厅列表的点击事件
            super.handleMessage(msg);

            adapter = new DiningAdapter(DiningActivity.this,ls);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //设置点击事件
                    Intent intent = new Intent();
                    intent.setClass(DiningActivity.this, YytActivity.class);
                    intent.putExtra("Context","DiningActivity");
                    intent.putExtra("Id",ls.get(i).getShop_id());
                    Log.e("SHOP_ID1",ls.get(i).getShop_id());
                    startActivityForResult(intent,i);
                }
            });
        }
    };
    public List<Dining> ls= new ArrayList<Dining>();//存放餐厅列表数据
    private String s = "";
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
        setDefault();

    }

    private void setDefault() {
        displayDining();
    }

    /**
     * 展示营业厅数据
     */
    private void displayYyt() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ls = new ArrayList<Dining>();
                Httpss http = new Httpss();
                NameValuePair pair = new BasicNameValuePair("city", Utils.city);
                s = http.setAndGet(u1,pair);
                ls = http.parser(s);
                Message msg = new Message();
                mHandler1.sendMessage(msg);

            }
        }).start();

    }


    /**
     * 展示餐厅列表
     */
    private void displayDining() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ls = new ArrayList<Dining>();
                Httpss http = new Httpss();
                NameValuePair pair = new BasicNameValuePair("city", Utils.city);
                s =http.setAndGet(u,pair);
                Log.e("ct",s);
                ls = http.parser(s);
                Log.e("Dining",ls.toString());
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
