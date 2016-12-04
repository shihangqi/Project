package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lenovo.inequalitysign.R;

public class MineProfileActivity extends AppCompatActivity {

    private ImageButton btn_back;
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.mine_profileB1:
                    Intent i = new Intent();
                    i.setClass(MineProfileActivity.this,AlreadyLogin.class);
                    startActivity(i);
                    break;
                case R.id.mine_profileB2:
                    //设置头像 从本地选择或者通过照相获取
                    break;
                case R.id.mine_profileB3:
                    //设置昵称
                    Intent ii = new Intent();
                    ii.setClass(MineProfileActivity.this,EditnameActivity.class);
                    startActivity(ii);
                    break;
                case R.id.mine_profileB4:
                    //设置性别
                    Intent intent = new Intent();
                    intent.setClass(MineProfileActivity.this,Gender.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_profile);
        findView();
        setOnClick();
    }

    private void setOnClick() {
        btn_back.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
        btn3.setOnClickListener(mListener);
    }

    private void findView() {
        btn_back = (ImageButton)findViewById(R.id.mine_profileB1);//回退按钮
        btn1 = (ImageButton)findViewById(R.id.mine_profileB2);//设置头像
        btn2  = (ImageButton)findViewById(R.id.mine_profileB3);//设置昵称
        btn3 = (ImageButton)findViewById(R.id.mine_profileB4);//设置性别
    }
}
