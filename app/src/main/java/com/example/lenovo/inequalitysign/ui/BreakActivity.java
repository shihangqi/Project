package com.example.administrator.budenghao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class BreakActivity extends Activity{

    private Button btn;
    @Override
    public  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_break);

        btn=(Button)findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BreakActivity.this,DiningInformationActivity.class);
                startActivity(i);
            }
        });
    }
}
