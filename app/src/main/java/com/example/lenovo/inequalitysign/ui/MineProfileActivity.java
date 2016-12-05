package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.inequalitysign.R;

public class MineProfileActivity extends AppCompatActivity {

    private ImageView mine_profileB1;
    private LinearLayout mine_profileB2;
    private LinearLayout mine_profileB3;
    private LinearLayout mine_profileB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_profile);

        mine_profileB1 = (ImageView) findViewById(R.id.mine_profileB1);//获取按钮
        mine_profileB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(mine_profile.this,
                        activity_alreadylogin.class);
                startActivity(i);
                mine_profile.this.finish();
            }//注册监听
        });
        mine_profileB3 = (LinearLayout) findViewById(R.id.mine_profileB3);//获取按钮
        mine_profileB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(mine_profile.this,
                        activity_editname.class);
                startActivity(i);
                mine_profile.this.finish();
            }//注册监听
        });

        mine_profileB4 = (LinearLayout) findViewById(R.id.mine_profileB4);//获取按钮
        mine_profileB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(mine_profile.this,
                        activity_gender.class);
                startActivity(i);
                mine_profile.this.finish();
            }//注册监听
        });
    }
}
