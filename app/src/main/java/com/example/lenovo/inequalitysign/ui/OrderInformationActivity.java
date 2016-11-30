package com.example.administrator.budenghao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class OrderInformationActivity extends Activity{
    private Button btn1;
    private Button btn;
    @Override
    public  void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.order_information);

        btn1=(Button)findViewById(R.id.back4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(OrderInformationActivity.this,NameActivity.class);
                startActivity(i1);
            }
        });

        btn=(Button)findViewById(R.id.btn_qxph);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OrderInformationActivity.this,BreakActivity.class);
                startActivity(i);


            }
        });


    }
}
