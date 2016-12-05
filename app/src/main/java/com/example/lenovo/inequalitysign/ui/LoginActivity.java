package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.inequalitysign.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView loginB1;
    private Button loginB2;
    private Button loginB3;
    private ImageView loginB4;
    private ImageView loginB5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginB1 = (ImageView) findViewById(R.id.loginB1);//获取按钮
        loginB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_login.this,
                        fragment_mine.class);
                startActivity(i);
                activity_login.this.finish();
            }//注册监听
        });

        loginB3 = (Button) findViewById(R.id.loginB3);//获取按钮
        loginB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_login.this,
                        activity_alreadylogin.class);
                startActivity(i);
                activity_login.this.finish();
            }//注册监听
        });
        loginB4 = (ImageView) findViewById(R.id.loginB4);//获取按钮
        loginB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_login.this,
                        login_blog.class);
                startActivity(i);
                activity_login.this.finish();
            }//注册监听
        });
        loginB5 = (ImageView) findViewById(R.id.loginB5);//获取按钮
        loginB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_login.this,
                        login_wechat.class);
                startActivity(i);
                activity_login.this.finish();
            }//注册监听
        });
    }
}
