package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btn;
    private EditText et_te1;
    private EditText et_pwd;
    private Button btn_login;
    private ImageButton btn_wb;
    private ImageButton btn_wx;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.loginB1:
                    Utils.flag = 4;
                    Intent i = new Intent();
                    i.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.loginB3:
                    //验证  验证码是否正确 如果正确跳已经登陆界面
                    Intent ii = new Intent();
                    ii.setClass(LoginActivity.this,AlreadyLogin.class);
                    startActivity(ii);
                    break;
                case R.id.loginB4:
                    //用微博登陆
                    break;
                case R.id.loginB5:
                    //用微信登陆
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        setOnClick();
    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn_login.setOnClickListener(mListener);
        btn_wb.setOnClickListener(mListener);
        btn_wx.setOnClickListener(mListener);

    }

    private void findView() {
        btn = (ImageButton)findViewById(R.id.loginB1);//退出按钮
        et_te1 = (EditText)findViewById(R.id.et_tel);//输入手机号
        et_pwd = (EditText)findViewById(R.id.et_pwd);//输入验证码
        btn_login = (Button)findViewById(R.id.loginB3);//登陆按钮
        btn_wb = (ImageButton)findViewById(R.id.loginB4);//微博登陆
        btn_wx = (ImageButton)findViewById(R.id.loginB5);//微信登陆
        
        
    }
}
