package com.example.lenovo.inequalitysign.entity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by lenovo on 2016/11/23.
 */
public class Comment extends AppCompatActivity{
    private commentContent mM;
    private ImageView Bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_comment);
        setDefaultPage();

        Bt_back = (ImageView) findViewById(R.id.C_back);
        Bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Comment.this,square.class);
                startActivity(intent);
            }
        });
    }

    private void setDefaultPage(){
        android.app.FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        mM =new commentContent();
        transaction.replace(R.id.contaner3,mM);
        transaction.commit();
    }
}
