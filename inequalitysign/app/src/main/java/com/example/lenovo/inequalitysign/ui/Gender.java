package com.example.lenovo.inequalitysign.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.http.Httpss;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Gender extends AppCompatActivity {
    private String u = Utils.USER_URL+"changesex";
    private ImageButton btn_back;
    private Button btn;
    private Button btn1;
    private String result=  "";
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(result.equals("changesexok")){
                Toast.makeText(Gender.this,"修改性别成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(Gender.this,"修改性别失败",Toast.LENGTH_SHORT).show();
            }
        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.genderB1:
                    //回退 跳到我的资料
                    Intent i = new Intent();
                    i.setClass(Gender.this,MineProfileActivity.class);
                    startActivity(i);
                    break;
                case R.id.genderB2:

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Httpss http = new Httpss();
                            NameValuePair pair1 = new BasicNameValuePair("user_sex","男");
                            NameValuePair pair11 = new BasicNameValuePair("id", Utils.id);
                            Log.e("sex",Utils.id);
                            result = http.setAndGet(u,pair1,pair11);
                            Message msg = new Message();
                            mHandler.sendMessage(msg);

                        }
                    }).start();
                    Intent ii = new Intent();
                    ii.setClass(Gender.this,MineProfileActivity.class);
                    startActivity(ii);
                    break;
                case R.id.genderB3:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Httpss http = new Httpss();
                            NameValuePair pair1 = new BasicNameValuePair("user_sex","女");
                            NameValuePair pair11 = new BasicNameValuePair("id", Utils.id);
                            result = http.setAndGet(u,pair1,pair11);
                            Message msg = new Message();
                            mHandler.sendMessage(msg);

                        }
                    }).start();
                    Intent intent = new Intent();
                    intent.setClass(Gender.this,MineProfileActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findView();
        setOnClick();
        
    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
        btn_back.setOnClickListener(mListener);
    }

    private void findView() {
        btn_back = (ImageButton) findViewById(R.id.genderB1);//回退按钮
        btn = (Button)findViewById(R.id.genderB2);//男
        btn1 = (Button)findViewById(R.id.genderB3);//女
    }
}
