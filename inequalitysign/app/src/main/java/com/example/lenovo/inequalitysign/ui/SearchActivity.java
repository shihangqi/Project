package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;

public class SearchActivity extends AppCompatActivity {

    private ImageButton btn_back;
    private EditText et;
    private Button btn;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_back:
                    //跳回主界面
                    Utils.flag = 1;
                    Intent i  = new Intent();
                    i.setClass(SearchActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.btn_search:
                    //如果搜索框没有内容  则不起作用，否则 显示搜索到的结果
                    if(et.getText().length() == 0){

                    }else{

                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        findView();
        setOnClick();

    }

    private void setOnClick() {
        btn_back.setOnClickListener(mListener);
        btn.setOnClickListener(mListener);
    }

    private void findView() {
        btn_back = (ImageButton)findViewById(R.id.btn_back);
        et = (EditText)findViewById(R.id.et);
        btn = (Button)findViewById(R.id.btn_search);

    }
}
