package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lenovo.inequalitysign.R;

public class Login_Wx extends AppCompatActivity {

    private ImageButton btn_back;
    private Button btn_login;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.wechatB1:
                    Intent i  = new Intent();
                    i.setClass(Login_Wx.this,LoginActivity.class);
                    startActivity(i);
                    break;
                case R.id.wechatB2:
                    Intent intent = new Intent();
                    intent.setClass(Login_Wx.this,AlreadyLogin.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_wx);
        findView();
    }

    private void findView() {
        btn_back = (ImageButton)findViewById(R.id.wechatB1);
        btn_login = (Button)findViewById(R.id.wechatB2);
    }
}
