package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tv1:
                Toast.makeText(SceneActivity.this,"tv1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv2:
                Toast.makeText(SceneActivity.this,"tv2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv3:
                Toast.makeText(SceneActivity.this,"tv3",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {
//        ls.add(new Scene(R.drawable.axiangpo,"1"));
//        ls.add(new Scene(R.drawable.budenghao,"2"));
//        ls.add(new Scene(R.drawable.chunbing1,"3"));
//        ls.add(new Scene(R.drawable.dianxin,"4"));
//        ls.add(new Scene(R.drawable.emei,"5"));
//        ls.add(new Scene(R.drawable.jiaotong,"6"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                Httpss http = new Httpss();
                String s = http.setAndGet(u);
                ls = http.parserScene(s);
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        }).start();

    }

}
