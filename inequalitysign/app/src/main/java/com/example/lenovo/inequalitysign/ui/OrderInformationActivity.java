package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.inequalitysign.R;

public class OrderInformationActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back4:
                    Intent intent=new Intent(OrderInformationActivity.this,DiningInformationActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_qxph:
                    finish();
                    break;
            }
        }
    };
    private TextView tv1;
    private TextView tv;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_information);
        finView();
        setOnClick();

    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
    }

    private void finView() {
        btn1=(Button)findViewById(R.id.back4);//回退
        btn=(Button)findViewById(R.id.btn_qxph);//取消排号
        tv = (TextView)findViewById(R.id.tv_name);//商家名称
        tv1 = (TextView)findViewById(R.id.tv_num);//取到的号
        tv2 = (TextView)findViewById(R.id.tv_num1);//当前已到
        tv3 = (TextView)findViewById(R.id.tv_num2);//还需等待

    }
}
