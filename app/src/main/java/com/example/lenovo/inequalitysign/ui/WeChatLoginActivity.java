package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.inequalitysign.R;

public class WeChatLoginActivity extends AppCompatActivity {

    private ImageView wechatB1;
    private Button wechatB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_wechat);

        wechatB1 = (ImageView) findViewById(R.id.wechatB1);//获取按钮
        wechatB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(login_wechat.this,
                        activity_login.class);
                startActivity(i);
                login_wechat.this.finish();
            }//注册监听
        });

        wechatB2 = (Button) findViewById(R.id.wechatB2);//获取按钮
        wechatB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(login_wechat.this,
                        activity_alreadylogin.class);
                startActivity(i);
                login_wechat.this.finish();
            }//注册监听
        });
    }
}
