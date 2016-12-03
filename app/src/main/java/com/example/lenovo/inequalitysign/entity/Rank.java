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
public class Rank extends AppCompatActivity {
    private rankContent mM;
    private ImageView Bt_rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_rank);
        setDefaultPage();
        Bt_rb = (ImageView) findViewById(R.id.rank_back);
        Bt_rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Rank.this,square.class);
                startActivity(intent);
            }
        });
    }
    private void setDefaultPage(){
        android.app.FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        mM =new rankContent();
        transaction.replace(R.id.contaner1,mM);
        transaction.commit();
    }
}
