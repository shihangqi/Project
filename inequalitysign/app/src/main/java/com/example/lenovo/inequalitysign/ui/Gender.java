package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.lenovo.inequalitysign.R;

public class Gender extends AppCompatActivity {

    private ImageButton btn_back;
    private Button btn;
    private Button btn1;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.genderB1:
                    //回退 跳到我的资料
                    Intent i = new Intent();
                    i.setClass(Gender.this,MineProfileActivity.class);
                    startActivity(i);
                    break;
                case R.id.genderB2:
                    Intent ii = new Intent();
                    ii.setClass(Gender.this,MineProfileActivity.class);
                    ii.putExtra("gender","男");
                    startActivity(ii);
                    break;
                case R.id.genderB3:
                    Intent intent = new Intent();
                    intent.setClass(Gender.this,MineProfileActivity.class);
                    intent.putExtra("gender","女");
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findView();
        
    }

    private void findView() {
        btn_back = (ImageButton) findViewById(R.id.genderB1);//回退按钮
        btn = (Button)findViewById(R.id.genderB2);//男
        btn1 = (Button)findViewById(R.id.genderB3);//女
    }
}
