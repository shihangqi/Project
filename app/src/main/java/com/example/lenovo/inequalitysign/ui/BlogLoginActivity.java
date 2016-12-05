package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.inequalitysign.R;

public class BlogLoginActivity extends AppCompatActivity {

    private ImageView blogB1;
    private Button blogB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_blog);

        blogB1 = (ImageView) findViewById(R.id.blogB1);//获取按钮
        blogB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(login_blog.this,
                        activity_login.class);
                startActivity(i);
                login_blog.this.finish();
            }//注册监听
        });

        blogB2 = (Button) findViewById(R.id.blogB2);//获取按钮
        blogB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(login_blog.this,
                        activity_alreadylogin.class);
                startActivity(i);
                login_blog.this.finish();
            }//注册监听
        });
    }
}
