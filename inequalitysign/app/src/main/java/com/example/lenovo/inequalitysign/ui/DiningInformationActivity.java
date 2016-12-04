package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.inequalitysign.R;

public class DiningInformationActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back3:
                    Intent i=new Intent(DiningInformationActivity.this,DiningActivity.class);
                    startActivity(i);
                    break;
                case R.id.btn_qh:
                    Intent intent = new Intent(DiningInformationActivity.this,OrderInformationActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_information);
        finView();
        setOnClick();
    }

    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);

    }

    private void finView() {
        btn1=(Button)findViewById(R.id.back3);//退出按钮
        btn=(Button)findViewById(R.id.btn_qh);//取号按钮
    }
}
