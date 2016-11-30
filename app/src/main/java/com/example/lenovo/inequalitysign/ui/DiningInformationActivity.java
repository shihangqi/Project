package com.example.administrator.budenghao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class DiningInformationActivity extends Activity {

    private Button btn1;
    private Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dining_information);

        btn1=(Button)findViewById(R.id.back3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DiningInformationActivity.this,ListActivity.class);
                startActivity(i);
            }
        });
        Button btn=(Button)findViewById(R.id.btn_qh);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DiningInformationActivity.this,OrderInformationActivity.class);
                startActivity(i);
            }
        });


    }
}
