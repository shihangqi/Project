package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.inequalitysign.R;

public class MineOrderActivity extends AppCompatActivity {

    private ImageView mine_orderB1;
    private ImageView mine_orderB2;
    private Button mine_orderB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_order);

        mine_orderB1 = (ImageView) findViewById(R.id.mine_orderB1);//获取按钮
        mine_orderB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(mine_order.this,
                        activity_alreadylogin.class);
                startActivity(i);
                mine_order.this.finish();
            }//注册监听
        });
    }
}
