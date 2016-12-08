package com.example.lenovo.inequalitysign.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lenovo.inequalitysign.R;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class EditnameActivity extends AppCompatActivity {

    private EditText et_name;
    private Button btn;
    private ImageButton btn_back;
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.editnameB1:
                    SharedPreferences spf1 = getSharedPreferences("count", Context.MODE_APPEND);
                    String name = spf1.getString("Name","");
                    if(et_name.getText().toString().length() == 0){
                        AlertDialog.Builder build = new AlertDialog.Builder(EditnameActivity.this);
                        build.setTitle("温馨提示");
                        build.setMessage("请输入昵称");
                        build.setPositiveButton("确定",null);
                        build.setNegativeButton("取消",null);
                    }
                    break;
                case R.id.editnameB2:
                    SharedPreferences spf = getSharedPreferences("count", Context.MODE_APPEND);
                    SharedPreferences.Editor editor = spf.edit();
                    editor.putString("Name",et_name.getText().toString());
                    Intent i = new Intent();
                    i.setClass(EditnameActivity.this,MineProfileActivity.class);
                    startActivity(i);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editname);
        et_name = (EditText)findViewById(R.id.et_name);
        btn = (Button)findViewById(R.id.editnameB2);
        btn_back = (ImageButton)findViewById(R.id.editnameB1);
        btn.setOnClickListener(mListener);
        btn_back.setOnClickListener(mListener);
        
    }
}
