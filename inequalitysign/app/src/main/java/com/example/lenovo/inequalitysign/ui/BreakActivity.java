package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.inequalitysign.R;

public class BreakActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);
        findView();
        setOnClick();
    }

    private void setOnClick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BreakActivity.this,DiningInformationActivity.class);
                startActivity(i);
            }
        });
    }

    private void findView() {
        btn=(Button)findViewById(R.id.back);
    }
}
