package com.example.lenovo.inequalitysign.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.entity.Dining;
import com.example.lenovo.inequalitysign.http.Httpss;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderInformationActivity extends AppCompatActivity {
    private String u = Utils.SHOP_URL+"join";
    private Button btn1;
    private Button btn;
    private String all;
    private String now;
    private String add;
    private String name;
    private TextView tv1;
    private TextView tv;
    private TextView tv2;
    private TextView tv3;
    private TextView tv_address;



    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back4:
                    Intent intent=new Intent(OrderInformationActivity.this,DiningInformationActivity.class);
                    Intent ii = getIntent();
                    String name1 = ii.getStringExtra("Name");
                    String id = ii.getStringExtra("Id");
                    String start1 = ii.getStringExtra("Context");
                    intent.putExtra("Name",name1);
                    intent.putExtra("Context",start1);
                    intent.putExtra("Id",id);
                    startActivity(intent);
                    break;
                case R.id.btn_qxph:
                    Intent i3 = getIntent();
                    String context = i3.getStringExtra("Context");
                    if(context.equals("HomeFragment")){
                        Intent i4 = new Intent();
                        Utils.flag =1;
                        i4.setClass(OrderInformationActivity.this,MainActivity.class);
                        startActivity(i4);
                    }else{
                        Intent i5 = new Intent();
                        i5.setClass(OrderInformationActivity.this, DiningActivity.class);
                        startActivity(i5);
                    }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_information);
        finView();
        setOnClick();
        Intent i = getIntent();
        name = i.getStringExtra("NAME");
        add = i.getStringExtra("ADDRESS");
        all = i.getStringExtra("ALL");
        now = i.getStringExtra("NOW");
        tv.setText(name);
        tv1.setText(all);
        tv2.setText(now);
        int i1 = Integer.parseInt(all)-Integer.parseInt(now);
        tv3.setText(i1+"");
        tv_address.setText(add);


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
        tv_address = (TextView)findViewById(R.id.tv_address);

    }
}
