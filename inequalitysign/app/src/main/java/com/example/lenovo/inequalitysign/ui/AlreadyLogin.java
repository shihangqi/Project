package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;

public class AlreadyLogin extends AppCompatActivity {

    private LinearLayout btn1;
    private LinearLayout btn2;
    private Button btn3;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.alreadyloginB1:
                    Intent i = new Intent();
                    i.setClass(AlreadyLogin.this,MineOrderActivity.class);
                    startActivity(i);
                    break;
                case R.id.alreadyloginB2:
                    Intent ii = new Intent();
                    ii.setClass(AlreadyLogin.this,MineProfileActivity.class);
                    startActivity(ii);
                    break;
                case R.id.alreadyloginB3:
                    Utils.flag = 4;
                    Intent intent = new Intent();
                    intent.setClass(AlreadyLogin.this,MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_login);
        findView();
        setOnClick();
    }

    private void setOnClick() {
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
        btn3.setOnClickListener(mListener);
    }

    private void findView() {
        btn1 = (LinearLayout)findViewById(R.id.alreadyloginB1);//排号记录
        btn2 = (LinearLayout)findViewById(R.id.alreadyloginB2);//我的资料
        btn3 = (Button)findViewById(R.id.alreadyloginB3);//退出当前账号按钮

    }
}
