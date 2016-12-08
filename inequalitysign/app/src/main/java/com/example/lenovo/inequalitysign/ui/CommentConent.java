package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.adapter.CommentAdapter;
import com.example.lenovo.inequalitysign.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentConent extends AppCompatActivity {
    private List<Comment> ls = new ArrayList<>();
    private ImageButton btn;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_conent);
        findView();
        setOnClick();
        CommentAdapter adapter = new CommentAdapter(CommentConent.this,ls);
        lv.setAdapter(adapter);
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
