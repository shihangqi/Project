package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Alreadylogin extends AppCompatActivity {

    private LinearLayout alreadyloginB1;
    private LinearLayout alreadyloginB2;
    private Button alreadyloginB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alreadylogin);

        alreadyloginB1 = (LinearLayout) findViewById(R.id.alreadyloginB1);//获取按钮
        alreadyloginB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_alreadylogin.this,
                        mine_order.class);
                startActivity(i);
                activity_alreadylogin.this.finish();
            }//注册监听
        });

        alreadyloginB2 = (LinearLayout) findViewById(R.id.alreadyloginB2);//获取按钮
        alreadyloginB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_alreadylogin.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });

        alreadyloginB3 = (Button) findViewById(R.id.alreadyloginB3);//获取按钮
        alreadyloginB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_alreadylogin.this,
                        fragment_mine.class);
                startActivity(i);
            }//注册监听
        });
    }
}
