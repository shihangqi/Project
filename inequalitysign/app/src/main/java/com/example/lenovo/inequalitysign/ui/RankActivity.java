package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.lenovo.inequalitysign.R;
import com.example.lenovo.inequalitysign.Utils.Utils;
import com.example.lenovo.inequalitysign.adapter.RankAdapter;
import com.example.lenovo.inequalitysign.entity.Rank;

import java.util.ArrayList;
import java.util.List;

public class RankActivity extends AppCompatActivity {
    private List<Rank> ls = new ArrayList<>();
    private ImageButton btn;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        findView();
        setOnClick();
        RankAdapter adapter = new RankAdapter(RankActivity.this,ls);
        lv.setAdapter(adapter);
    }

    private void setOnClick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.flag = 2;
                Intent intent = new Intent();
                intent.setClass(RankActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findView() {
        btn = (ImageButton)findViewById(R.id.rank_back);
        lv = (ListView)findViewById(R.id.lv);
    }
}
