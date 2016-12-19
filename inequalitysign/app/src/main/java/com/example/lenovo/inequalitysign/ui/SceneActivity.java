package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;


import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.adapter.MasonryAdapter;
import com.example.lenovo.inequalitysign.entity.Scene;
import com.example.lenovo.inequalitysign.http.Httpss;

import java.util.ArrayList;
import java.util.List;

public class SceneActivity extends AppCompatActivity {
    private String u = Utils.SHOP_URL+"scene";
    private List<Scene> ls = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageButton btn_back;
    private ImageButton btn_menu;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MasonryAdapter adapter = new MasonryAdapter(ls);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            //设置adapter
            recyclerView.setAdapter(adapter);
            //设置item之间的间隔
            SpacesItemDecoration decoration=new SpacesItemDecoration(15);
            recyclerView.addItemDecoration(decoration);

        }
    };
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.S_back:
                    Intent i = new Intent();
                    Utils.flag = 2;
                    i.setClass(SceneActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.S_menu:
                    View view1 = getLayoutInflater().inflate(R.layout.activity_popupwindow,null);
                    PopupWindow window = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
                    window.showAsDropDown(btn_menu);
                    break;
                case R.id.camera:

                    break;
                case R.id.picture:
                    break;
                case R.id.cancle:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        findView();
        setOnClick();
        initData();
        recyclerView= (RecyclerView) findViewById(R.id.recylerview);

    }

    private void setOnClick() {
        btn_back.setOnClickListener(mListener);
        btn_menu.setOnClickListener(mListener);
    }

    private void findView() {
        btn_back = (ImageButton)findViewById(R.id.S_back);
        btn_menu = (ImageButton)findViewById(R.id.S_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }



    private void initData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Httpss http = new Httpss();
                String s = http.setAndGet(u);
                Log.e("SCENE",s);
                ls = http.parserScene(s);
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        }).start();

    }

}
