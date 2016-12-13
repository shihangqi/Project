package com.example.lenovo.inequalitysign.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
import java.util.jar.Attributes;

public class SearchActivity extends AppCompatActivity {
    private String u = Utils.SHOP_URL+"search";
    private ImageButton btn_back;
    private EditText et;
    private Button btn;
    private ListView lv;
    private List<Dining> ls = new ArrayList<>();
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what ==1){
                lv.setVisibility(View.VISIBLE);
                DiningAdapter adapter = new DiningAdapter(SearchActivity.this,ls);
                lv.setAdapter(adapter);
            }else{
                lv.setVisibility(View.GONE);
            }


        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_back:
                    //跳回主界面
                    Utils.flag = 1;
                    Intent i  = new Intent();
                    i.setClass(SearchActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.btn_search:
                    //如果搜索框没有内容  则不起作用，否则 显示搜索到的结果
                    if(et.getText().length() == 0){
                        AlertDialog.Builder adb = new AlertDialog.Builder(SearchActivity.this);
                        adb.setTitle("温馨提示");
                        adb.setMessage("请输入查询内容");
                        adb.setPositiveButton("确定", null);
                        adb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent ii = new Intent();
                                Utils.flag = 1;
                                ii.setClass(SearchActivity.this,MainActivity.class);
                                startActivity(ii);
                            }
                        });
                        adb.create();
                        adb.show();
                    }else{
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Httpss  http = new Httpss();
                                    NameValuePair pair = new BasicNameValuePair("content",et.getText().toString());
                                    NameValuePair pair1 = new BasicNameValuePair("city",Utils.city);
                                    String s = http.setAndGet(u,pair,pair1);
                                    ls = http.parser(s);
                                    Message msg = new Message();
                                    mHandler.sendMessage(msg);
                                }
                            }).start();
                    }//end else
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        findView();
        setOnClick();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

            @Override
            public void afterTextChanged(final Editable editable) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ls.clear();
                        String s1 = editable.toString();
                        Log.e("S1",s1);
                        Message msg = new Message();
                        if(s1.length()!= 0 ){

                            Httpss  http = new Httpss();
                            NameValuePair pair = new BasicNameValuePair("content",s1);
                            NameValuePair pair1 = new BasicNameValuePair("city",Utils.city);
                            String s = http.setAndGet(u,pair,pair1);
                            ls = http.parser(s);
                            msg.what = 1;

                        }else{
                           msg.what = 0;
                        }

                        mHandler.sendMessage(msg);

                    }
                }).start();
            }
        });

    }

    private void setOnClick() {
        btn_back.setOnClickListener(mListener);
        btn.setOnClickListener(mListener);
    }

    private void findView() {
        btn_back = (ImageButton)findViewById(R.id.btn_back);
        et = (EditText)findViewById(R.id.et);
        btn = (Button)findViewById(R.id.btn_search);
        lv = (ListView)findViewById(R.id.lv);
    }
}
