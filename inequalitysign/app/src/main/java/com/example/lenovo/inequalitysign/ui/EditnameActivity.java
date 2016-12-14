package com.example.lenovo.inequalitysign.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.http.Httpss;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class EditnameActivity extends AppCompatActivity {
    private String u = Utils.USER_URL+"changename";
    private EditText et_name;
    private Button btn;
    private ImageButton btn_back;
    private String result ="";
    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(result.equals("changenameok")){
                Toast.makeText(EditnameActivity.this,"修改名字成功",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(EditnameActivity.this,"修改名字失败",Toast.LENGTH_SHORT).show();
            }
        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.editnameB1:
                    Intent ii = new Intent();
                    ii.setClass(EditnameActivity.this,MineProfileActivity.class);
                    startActivity(ii);
                    break;
                case R.id.editnameB2:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Httpss http = new Httpss();
                            NameValuePair pair1 = new BasicNameValuePair("user_name",et_name.getText().toString());
                            NameValuePair pair11 = new BasicNameValuePair("id", Utils.id);
                            result = http.setAndGet(u,pair1,pair11);
                            Message msg = new Message();
                            mHandler.sendMessage(msg);

                        }
                    }).start();
                    Intent i = new Intent();
                    i.setClass(EditnameActivity.this,MineProfileActivity.class);
                    startActivity(i);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editname);
        et_name = (EditText)findViewById(R.id.et_name);
        btn = (Button)findViewById(R.id.editnameB2);
        btn_back = (ImageButton)findViewById(R.id.editnameB1);
        btn.setOnClickListener(mListener);
        btn_back.setOnClickListener(mListener);
        
    }
}
