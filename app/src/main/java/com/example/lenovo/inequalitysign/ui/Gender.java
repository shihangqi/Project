package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Gender extends AppCompatActivity {

    private ImageView genderB1;
    private Button genderB2;
    private Button genderB3;
    private Button genderB4;
    private Button genderB5;
    private Button genderB6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        genderB1 = (ImageView) findViewById(R.id.genderB1);//获取按钮
        genderB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_gender.this,
                        mine_profile.class);
                startActivity(i);
                activity_gender.this.finish();
            }//注册监听
        });

        genderB2 = (Button) findViewById(R.id.genderB2);//获取按钮
        genderB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_gender.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });
        genderB3 = (Button) findViewById(R.id.genderB3);//获取按钮
        genderB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_gender.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });
        genderB4 = (Button) findViewById(R.id.genderB4);//获取按钮
        genderB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_gender.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });
        genderB5 = (Button) findViewById(R.id.genderB5);//获取按钮
        genderB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_gender.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });
        genderB6 = (Button) findViewById(R.id.genderB6);//获取按钮
        genderB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_gender.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });
    }
}
