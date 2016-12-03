package com.example.lenovo.inequalitysign.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.budh.sceneContent;
import com.example.lenovo.inequalitysign.square;

public class SceneActivity extends AppCompatActivity {

    private sceneContent mM;
    private ImageView Bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_scene);
        setDefaultPage();
        Bt_back = (ImageView)findViewById(R.id.S_back);
        Bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SceneActivity.this,square.class);
                startActivity(intent);
            }
        });
    }

    private void setDefaultPage(){
        android.app.FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        mM =new sceneContent();
        transaction.replace(R.id.contaner2,mM);
        transaction.commit();
    }
}
