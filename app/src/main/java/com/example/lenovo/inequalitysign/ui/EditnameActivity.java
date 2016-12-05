package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.inequalitysign.R;

public class EditnameActivity extends AppCompatActivity {

    private ImageView editnameB1;
    private Button editnameB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editname);
        editnameB1 = (ImageView) findViewById(R.id.editnameB1);//获取按钮
        editnameB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_editname.this,
                        mine_profile.class);
                startActivity(i);
                activity_editname.this.finish();
            }//注册监听
        });
        editnameB2 = (Button) findViewById(R.id.editnameB2);//获取按钮
        editnameB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(activity_editname.this,
                        mine_profile.class);
                startActivity(i);
            }//注册监听
        });
    }
}
