package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lenovo.inequalitysign.R;

import java.util.ArrayList;
import java.util.List;

public class DiningActivity extends AppCompatActivity {
    private Button btn;
    private Button btn1;
    private Button btn2;
    private ListView lv;
    private List<String> ls= new ArrayList<String>();//存放餐厅列表数据
    private List<String> list = new ArrayList<>();//存放营业厅列表数据
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back1:
                    Intent i = new Intent();
                    i.setClass(DiningActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.ct:
                    //展示餐厅列表数据
                    displayDining();
                    break;
                case R.id.yyt:
                    //展示营业厅列表数据
                    displayYyt();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
        findView();
        setOnClick();
    }

    /**
     * 展示营业厅数据
     */
    private void displayYyt() {

    }


    /**
     * 展示餐厅列表
     */
    private void displayDining() {

    }


    private void setOnClick() {
        btn.setOnClickListener(mListener);
        btn1.setOnClickListener(mListener);
        btn2.setOnClickListener(mListener);
    }

    private void findView() {
        btn2=(Button)findViewById(R.id.yyt);
        btn=(Button)findViewById(R.id.back1);
        btn1 = (Button)findViewById(R.id.ct);
        lv = (ListView)findViewById(R.id.Lv);
    }
}
