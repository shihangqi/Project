package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.adapter.CommentAdapter;
import com.example.lenovo.inequalitysign.entity.Comment;
import com.example.lenovo.inequalitysign.http.Httpss;

import java.util.ArrayList;
import java.util.List;

public class CommentConent extends AppCompatActivity {
    private String u = Utils.SHOP_URL+"comment";
    private List<Comment> ls = new ArrayList<>();
    private ImageButton btn;
    private ListView lv;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("Comment",ls.toString());
            CommentAdapter adapter = new CommentAdapter(CommentConent.this,ls);
            lv.setAdapter(adapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_conent);

        findView();
        setOnClick();
        getContent();
    }

    private void getContent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Httpss  http = new Httpss();
                String s = http.setAndGet(u);
                Log.e("Comment",s);
                ls = http.parserComment(s);
                Log.e("Comment",ls.size()+"\t"+ls.toString());
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        }).start();
    }

    private void setOnClick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.flag = 2;
                Intent i = new Intent();
                i.setClass(CommentConent.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void findView() {
        btn = (ImageButton)findViewById(R.id.C_back);
        lv = (ListView)findViewById(R.id.lv);
    }

}
