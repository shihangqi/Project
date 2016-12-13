package com.example.lenovo.inequalitysign.ui;

import android.content.Intent;
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
import com.example.lenovo.inequalitysign.adapter.RankAdapter;
import com.example.lenovo.inequalitysign.entity.Rank;
import com.example.lenovo.inequalitysign.http.Httpss;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class RankActivity extends AppCompatActivity {
    private String u = Utils.SHOP_URL+"list";
    private List<Rank> ls = new ArrayList<>();
    private ImageButton btn;
    private ListView lv;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RankAdapter adapter = new RankAdapter(RankActivity.this,ls);
            lv.setAdapter(adapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        findView();
        setOnClick();
       getContent();
    }

    private void getContent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Httpss http = new Httpss();
                NameValuePair pair = new BasicNameValuePair("city",Utils.city);
                String s  = http.setAndGet(u,pair);
                Log.e("S",s);
                ls = http.parserRank(s);
                Message msg = new Message();
                handler.sendMessage(msg);

            }
        }).start();
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
