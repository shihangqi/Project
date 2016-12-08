package com.example.lenovo.inequalitysign.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity{
    private LinearLayout ll;
    private Button mBtnSy,mBtnGc,mBtnFj,mBtnWd;
    //private MyDdFragment mDd;
    private HomeFragment mM;
    private LinearLayout edt;
    private Spinner spinner;

    //private MySpFragment mSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        spinner = (Spinner) findViewById(R.id.spinnerid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_spinner_item);
        String level[] = getResources().getStringArray(R.array.languages);//资源文件
        for (int i = 0; i < level.length; i++) {
            adapter.add(level[i]);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        edt=(Button)findViewById(R.id.btn_search);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        //setListener();
        setDefaultPage();
    }

    private void  getViews(){
        ll=(LinearLayout)findViewById(R.id.ll);
        mBtnSy=(Button)findViewById(R.id.btn_sy);
        mBtnGc=(Button)findViewById(R.id.btn_gc);
        mBtnFj=(Button)findViewById(R.id.btn_fj);
        mBtnWd=(Button)findViewById(R.id.btn_wd);
    }
   /* private void setListener(){
        MyListner listner=new MyListner();
        mBtnSy.setOnClickListener(listner);
        mBtnGc.setOnClickListener(listner);
        mBtnFj.setOnClickListener(listner);
        mBtnWd.setOnClickListener(listner);
    }
    */
    private void setDefaultPage(){
        android.app.FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        mM =new HomeFragment();
        transaction.replace(R.id.contaner,mM);
        transaction.commit();
    }
    /*class  MyListner implements View.OnClickListener{
        @Override
        public void onClick(View v){
            android.app.FragmentManager fm=getFragmentManager();
            FragmentTransaction transaction=fm.beginTransaction();
            switch(v.getId()) {
                case R.id.btn_sp:
                    if (mSp == null) {
                        mSp = new MySpFragment();
                    }
                    transaction.replace(R.id.contaner, mSp);
                    break;
                case R.id.btn_xx:
                    if (mXx == null) {
                        mXx = new MyXxFragment();
                    }
                    transaction.replace(R.id.contaner,mXx);
                    break;
                case R.id.btn_dd:
                    if (mDd == null) {
                        mDd = new MyDdFragment();
                    }
                    transaction.replace(R.id.contaner,mDd);
                    break;
            }
            transaction.commit();
            ll.invalidate();
        }
    }*/
}


